package tm.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/map")
public class MapController {
    @RequestMapping(method = RequestMethod.GET)
    public String map(Model model, @Param("address") String address){
        model.addAttribute("address", address);
        return "map";
    }
}
