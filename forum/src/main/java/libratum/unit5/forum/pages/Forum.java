package libratum.unit5.forum.pages;

import daos.DynamoDBConfig;
import daos.PostThreadDAO;
import libratum.unit5.forum.ForumApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Forum {

    private final PostThreadDAO dao = new PostThreadDAO(ForumApplication.getDB());
    @RequestMapping(value="/")
    public String forum(Model model) {
        model.addAttribute("dao", this.dao);
        return "main/forum";
    }

    @RequestMapping(value = "/registration")
    public String registration() {
        return "redirect:/account";
    }
}
