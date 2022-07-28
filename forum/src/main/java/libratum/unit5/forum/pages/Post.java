package libratum.unit5.forum.pages;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import daos.PostDAO;
import daos.PostThreadDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thread-{PostThreadId}")
public class Post {

    private final PostDAO dao = new PostDAO();

    @GetMapping(value = "")
    public String postThread(
            @PathVariable(value = "PostThreadId") String id,
            Model model) {


        PostThreadDAO dao = new PostThreadDAO();
        model.addAttribute("PostThread", dao.findById(id));

        model.addAttribute("PostThreadId", id);
        return "posts/post";
    }
}
