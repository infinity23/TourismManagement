package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.pojo.Tourist;
import tm.service.TouristService;

@Controller
@RequestMapping("/touristRegister")
public class TouristRegisterController {
    private TouristService touristService;
    private Tourist tourist;

    @Autowired
    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    @Autowired
    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String touristRegister(Model model){
        model.addAttribute("tourist",tourist);
        return "touristRegister";
    }


    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(Tourist tourist){
        touristService.add(tourist);
        return "redirect:/touristRetrieval";
    }
}
