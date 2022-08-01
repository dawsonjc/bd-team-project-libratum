package libratum.unit5.forum.pages;

import daos.UsersDAO;
import libratum.unit5.forum.ForumApplication;
import models.UserType;
import models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/account")
public class Account {

    private final UsersDAO dao = new UsersDAO(ForumApplication.getDB());

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

        user.setFavorites(new ArrayList<models.Wine>());
        user.setPosts(new ArrayList<models.Post>());
        user.setType(UserType.USER);
        user.setBio("");

        this.dao.saveUser(user);

        redirectAttributes.addFlashAttribute("current_user", user);
        return "redirect:/account";
    }

    @PostMapping(value = "login")
    public String loginUser(Model model,
                            @ModelAttribute(value = "login_user") Users userToLogin
    ) {
        // id = null, username = "burghurgle", password = "asdf", etc = null;
        // SELECT COUNT(*) FROM user_table WHERE username = aklsjdf AND password = "asdfasdf";

        Users user = this.dao.findByUsername(userToLogin.getUsername());

        if(!user.equals(userToLogin)) {
            return "redirect:/account/registration";
        }

        model.addAttribute("current_user", user);

        return "main/forum";
    }

    @RequestMapping(value="")
    public String account(@ModelAttribute(value = "current_user") Users user) {
        if(user.getId() == null) {
            return "redirect:/account/registration";
        }
        return "account/account";
    }

}
