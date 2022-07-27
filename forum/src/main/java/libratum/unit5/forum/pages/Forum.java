package libratum.unit5.forum.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Forum {
    @RequestMapping(value="/")
    public String forum(Model model) {
        return "main/forum";
    }

    @RequestMapping(value = "/registration")
    public String registration() {
        return "redirect:/account";
    }
}
