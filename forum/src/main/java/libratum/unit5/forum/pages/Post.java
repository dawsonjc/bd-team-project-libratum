package libratum.unit5.forum.pages;

import daos.PostDAO;
import daos.PostThreadDAO;
import daos.UsersDAO;
import libratum.unit5.forum.ForumApplication;
import models.PostThread;
import models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value = "/thread")
public class Post {

    private final PostDAO dao = new PostDAO(ForumApplication.getDB());
    private final PostThreadDAO postThreadDAO = new PostThreadDAO(ForumApplication.getDB());
    private final UsersDAO userDAO = new UsersDAO(ForumApplication.getDB());

    @GetMapping(value = "thread-{PostThreadId}")
    public String postThread(
            @PathVariable(value = "PostThreadId") String id,
            Model model) {

        model.addAttribute("PostThread", this.postThreadDAO.findById(id));

        model.addAttribute("PostThreadId", id);
        return "posts/post";
    }


    @PostMapping(value = "thread-{PostThreadId}/post")
    public ResponseEntity<models.Post> post(@PathVariable("PostThreadId") String threadId,
                                                  Model model,
                                                  @RequestParam("content") String content,
                                                  @RequestParam("postId") String postId) {
        PostThread thread = (PostThread) model.getAttribute("PostThread");

        Users currentUser = (Users) model.getAttribute("current_user");

        if(thread == null) {
            throw new exceptions.PostNotFoundException();
        }
        if(currentUser == null) {
            throw new exceptions.UserNotFoundException();
        }

        models.Post post = new models.Post(
                this.dao.findById(postId),
                thread,
                currentUser,
                content,
                new java.util.Date(),
                0
        );


        thread.addPost(post);
        currentUser.getPosts().add(post);

        // update db
        this.postThreadDAO.update(threadId, thread);
        this.userDAO.update(currentUser.getId(), currentUser);

        return ResponseEntity.ok(post);
    }


    @PostMapping(value = "create-thread")
    public String createPost(Model model,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "post_content") String postContent
    ) {
        Users user = (Users) model.getAttribute("current_user");
        System.out.println(user);
        System.out.println(title);
        System.out.println(postContent);
        PostThread thread = new PostThread();

        thread.setTitle(title);

        models.Post post = new models.Post();
        post.setParentPost(null);
        post.setPostThread(thread);
        post.setFromUser(user);
        post.setContent(postContent);
        post.setDate(new Date());
        post.setLikes(0);

        ArrayList<models.Post> posts = new ArrayList<models.Post>();
        posts.add(post);
        thread.setPosts(posts);

        PostThreadDAO dao = new PostThreadDAO(ForumApplication.getDB());
        dao.savePostThread(thread);

        return "redirect:/thread/thread-" + thread.getId();
    }



}
