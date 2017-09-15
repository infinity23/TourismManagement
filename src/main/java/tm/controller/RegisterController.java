package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.pojo.Hotel;
import tm.pojo.User;
import tm.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    private Hotel hotel;
    private User user;
    private UserService userService;

    @Autowired
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value = {"/register","/hotel/register"}, method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submit(Model model, User user){
        if(userService.findByName(user.getUsername()) != null){
            model.addAttribute("duplicateuser", "用户名已注册");
            model.addAttribute("user", user);
            return "register";
        }
        userService.addAdmin(user);
        return "/login";
    }

    @RequestMapping(value = "/hotel/register", method = RequestMethod.POST)

    //前往登记hotel详情
    public String hotelSubmit(Model model, User user, HttpSession session){
        if(userService.findByName(user.getUsername()) != null){
            model.addAttribute("duplicateuser", "用户名已注册");
            model.addAttribute("user", user);
            return "register";
        }
        session.setAttribute("user",user);
        return "control/toHotelRegister";
    }

}
