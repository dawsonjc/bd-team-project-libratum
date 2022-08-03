package libratum.unit5.forum.pages;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import daos.UsersDAO;
import libratum.unit5.forum.ForumApplication;
import models.UserType;
import models.Users;
import models.converter.ConverterForUser;
import models.converter.ListConverterForPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/account")
public class Account {

    private final UsersDAO dao = new UsersDAO(ForumApplication.getDB());

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value="registration")
    public String accountPage(Model model) {
        model.addAttribute("register_user", new Users());
        model.addAttribute("login_user", new Users());
        return "account/registration";
    }

    @PostMapping(value = "register")
    @DynamoDBTypeConverted(converter = ConverterForUser.class)
    public String registerUser(Model model,
                               RedirectAttributes redirectAttributes,
                               @ModelAttribute(value = "register_user") Users user
    ) {


        user.setFavorites(new ArrayList<models.Wine>());
        user.setPosts(new ArrayList<models.Post>());
        user.setType(UserType.USER);
        user.setBio("");

        this.dao.saveUser(user);
        request.getSession().setAttribute("current_user", user);
        redirectAttributes.addFlashAttribute("current_user", user);
        return "redirect:/account";
    }

    @GetMapping(value = "login")
    public String loginUser(Model model,
                            @ModelAttribute(value = "login_user") Users userToLogin
    ) {
        // id = null, username = "burghurgle", password = "asdf", etc = null;
        // SELECT COUNT(*) FROM user_table WHERE username = aklsjdf AND password = "asdfasdf";

        System.out.println("Trying to find user with: " + userToLogin);

        UsersDAO dao1 = new UsersDAO(ForumApplication.getDB());

        Users user = dao1.findByUsername(userToLogin.getUsername());

        System.out.println("Found user with: " + user);

        if(user == null || !user.equals(userToLogin)) {
            request.getSession().setAttribute("current_user", user);
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
