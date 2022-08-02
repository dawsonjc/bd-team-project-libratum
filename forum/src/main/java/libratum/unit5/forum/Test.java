package libratum.unit5.forum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Test {

    @RequestMapping(value = "/myerror")
    public String errorPage() {
        return "This is a big error page";
    }
}
