package libratum.unit5.forum.pages;

import models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String registerUser(@ModelAttribute(value = "register_user") Users user) {
        return null;
    }

    @PostMapping(value = "login")
    public String loginUser(@ModelAttribute(value = "login_user") Users user) {
        return null;
    }

    @RequestMapping(value="")
    public String account() {
        return "account/account";
    }

}
