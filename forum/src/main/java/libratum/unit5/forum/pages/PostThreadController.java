package libratum.unit5.forum.pages;

import daos.PostThreadDAO;
import models.PostThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poststhread")
public class PostThreadController {

        @Autowired
        private PostThreadDAO postThreadDAO;

        @PostMapping
        public PostThread saveThread(@RequestBody PostThread postThread) {
            return postThreadDAO.savePostThread(postThread);
        }

        @GetMapping("{id}")
        public PostThread getThread(@PathVariable("id")String id) {
            return postThreadDAO.findById(id);
        }

        @DeleteMapping("{id}")
        public String deleteThread(@PathVariable("id")String id) {
            return postThreadDAO.deletePostThread(id);
        }

        @PutMapping("{id}")
        public String updateThread(@PathVariable("id")String id,@RequestBody PostThread postThread ) {
            return postThreadDAO.update(id,postThread);
        }
}
