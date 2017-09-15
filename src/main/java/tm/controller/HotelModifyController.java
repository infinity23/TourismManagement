package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.pojo.Hotel;
import tm.service.HotelService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/hotel/hotelModify")
public class HotelModifyController {
    private HotelService hotelService;

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hotelModify(Model model, HttpSession session){
        int id = (int) session.getAttribute("id");
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel", hotel);
        return "hotelModify";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Hotel hotel){
        hotelService.update(hotel);
        return "redirect:/hotel";
    }
}
