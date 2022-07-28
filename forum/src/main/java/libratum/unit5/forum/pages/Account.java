package libratum.unit5.forum.pages;

import models.UserType;
import models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/account")
public class Account {

    @RequestMapping(value="registration")
    public String accountPage(Model model) {
        model.addAttribute("register_user", new Users());
        model.addAttribute("login_user", new Users());
        return "account/registration";
    }

    @PostMapping(value = "register")
    public String registerUser(Model model,
                               RedirectAttributes redirectAttributes,
                               @ModelAttribute(value = "register_user") Users user
    ) {
        user.setType(UserType.USER);
        user.setBio("");
        redirectAttributes.addFlashAttribute("current_user", user);
        return "redirect:/account";
    }

    @PostMapping(value = "login")
    public String loginUser(Model model,
                            @ModelAttribute(value = "login_user") Users user
    ) {
        model.addAttribute("current_user", user);
        System.out.println("login| Information received with: " + user.toString());
        return "main/forum";
    }

    @RequestMapping(value="")
    public String account(@ModelAttribute(value = "current_user") Users user) {
        return "account/account";
    }

}
