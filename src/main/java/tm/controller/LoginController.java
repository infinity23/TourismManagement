package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.pojo.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private User user;

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    public String login(Model model){
        model.addAttribute(user);
        return "login";
    }

    @RequestMapping("/failure")
    public String loginFailure(Model model, HttpSession session){
        String s = ((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage();
        if(s.equals("UsernameNotFoundException")){
            model.addAttribute("usernotfound","用户不存在");
        }else {
            model.addAttribute("passworderror", "密码错误");
        }
        model.addAttribute(user);
        return "login";
    }


}
