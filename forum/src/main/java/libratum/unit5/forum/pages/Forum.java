package libratum.unit5.forum.pages;

import daos.PostThreadDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Forum {

    private final PostThreadDAO dao = new PostThreadDAO();
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
