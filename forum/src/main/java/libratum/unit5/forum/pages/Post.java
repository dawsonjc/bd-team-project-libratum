package libratum.unit5.forum.pages;

import daos.PostDAO;
import daos.PostThreadDAO;
import libratum.unit5.forum.ForumApplication;
import models.PostThread;
import models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value = "/thread")
public class Post {

    private final PostDAO dao = new PostDAO();

    @GetMapping(value = "thread-{PostThreadId}")
    public String postThread(
            @PathVariable(value = "PostThreadId") String id,
            Model model) {

        PostThreadDAO dao = new PostThreadDAO(ForumApplication.getDB());
        model.addAttribute("PostThread", dao.findById(id));

        model.addAttribute("PostThreadId", id);
        return "posts/post";
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

        return "redirect:/";
    }
}
