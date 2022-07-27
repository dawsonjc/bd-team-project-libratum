package libratum.unit5.forum;

import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class Test {

    @RequestMapping(value = "/eror")
    public String errorPage() {
        return "This is a big errogr pae";
    }
}
