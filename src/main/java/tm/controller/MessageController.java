package tm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/message")
public class MessageController {
    @RequestMapping(value = "/mustLogin",method = RequestMethod.GET)
    public String message(Model model){
        model.addAttribute("info", "登录以后才可操作");
        return "message";
    }
}
