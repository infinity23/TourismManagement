package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.pojo.Hotel;
import tm.pojo.User;
import tm.service.HotelService;

import javax.servlet.http.HttpSession;

@Controller
public class HotelRegisterController {
    private Hotel hotel;
    private HotelService hotelService;

    @Autowired
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

//    @RequestMapping(value = "/hotelRegister", method = RequestMethod.GET)
//    public String hotelRegister(Model model){
//        model.addAttribute("hotel",hotel);
//        return "hotelRegister";
//    }
//
//    @RequestMapping(value = "/hotelRegister",method = RequestMethod.POST)
//    public String submit(Hotel hotel){
//         hotelService.add(hotel);
//        return "redirect:/hotelRetrieval";
//    }


    //只能以绑定hotel的方式注册帐号
    @RequestMapping(value = "/hotel/hotelRegister", method = RequestMethod.GET)
    public String hotelRegister2 (Model model){
        model.addAttribute("hotel",hotel);
        return "userHotelRegister";
    }

    @RequestMapping(value = "/hotel/hotelRegister",method = RequestMethod.POST)
    public String submit2(Hotel hotel, HttpSession session){
        hotelService.registerHotel(hotel, (User) session.getAttribute("user"));
        return "redirect:/hotel";
    }
}
