package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tm.pojo.Hotel;
import tm.pojo.RetrievalCondition;
import tm.service.HotelService;
import tm.utils.PageHandler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/hotelRetrieval")
public class HotelRetrievalController {
    private RetrievalCondition retrievalCondition;
    private List<Hotel> list;
    private HotelService hotelService;
    private PageHandler pageHandler;

    @Autowired
    public void setPageHandler(PageHandler pageHandler) {
        this.pageHandler = pageHandler;
    }

    @Autowired
    public void setRetrievalCondition(RetrievalCondition retrievalCondition) {
        this.retrievalCondition = retrievalCondition;
    }

    @Autowired
    public void setList(List<Hotel> list) {
        this.list = list;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hotelRetrieval(Model model) {
//        list = hotelService.listPage(0,20);
//        model.addAttribute("hotels",list);
        model.addAttribute(retrievalCondition);
        model.addAttribute("path","/hotelRetrieval/");
        model.addAttribute("title","农家乐信息检索");
        return "commonRetrieval";
    }

    @RequestMapping(value = "/page")
    public String pageSubmit(RetrievalCondition condition, @RequestParam int pageNum) {
        if(condition.getCondition() != null){
            retrievalCondition.setCondition(condition.getCondition());
            retrievalCondition.setValue(condition.getValue());
        }
        pageHandler.setPage(pageNum);

        return "redirect:/hotelRetrieval/list";
    }

    @RequestMapping(value = "/list")
    public String page(Model model){
        list = new ArrayList<>();
        switch (retrievalCondition.getCondition()) {
            case "all":
                list = hotelService.listPage();break;
            case "byName":
                list.add(hotelService.findByName(retrievalCondition.getValue()));
        }
        model.addAttribute("hotels", list);
        model.addAttribute("retrievalCondition", retrievalCondition);

        pageHandler.setModel(model,"/hotelRetrieval/page");
        return "hotelRetrieval";
    }


    @RequestMapping(value = "/detail/{id}", method = GET)
    public String detail(
            @PathVariable("id") int id,
            Model model) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute(hotel);
        return "hotelDetail";
    }

    @RequestMapping(value = "/modify/{id}", method = GET)
    public String modify(  @PathVariable("id") int id,
                           Model model) {
        Hotel hotel = hotelService.findById(id);
        model.addAttribute(hotel);
        return "hotelModify";
    }

    @RequestMapping(value = "/modify/{id}", method = POST)
    public String submit(  @PathVariable("id") int id,
                           Model model, Hotel hotel) {
        hotelService.update(hotel);
        model.addAttribute(hotel);
        return "redirect:/hotelRetrieval/detail/" + id;
    }


}
