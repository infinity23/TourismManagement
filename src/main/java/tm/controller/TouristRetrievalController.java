package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tm.pojo.RetrievalCondition;
import tm.pojo.Tourist;
import tm.service.TouristService;
import tm.utils.PageHandler;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/touristRetrieval")
public class TouristRetrievalController {
    private TouristService touristService;
    private RetrievalCondition retrievalCondition;
    private List<Tourist> list;
    private PageHandler pageHandler;

    @Autowired
    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @Autowired
    public void setPageHandler(PageHandler pageHandler) {
        this.pageHandler = pageHandler;
    }

    @Autowired
    public void setList(List<Tourist> list) {
        this.list = list;
    }

    @Autowired
    public TouristRetrievalController(TouristService touristService) {
        this.touristService = touristService;
    }

    @Autowired
    public void setRetrievalCondition(RetrievalCondition retrievalCondition) {
        this.retrievalCondition = retrievalCondition;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String touristRetrieval(Model model) {
            model.addAttribute("retrievalCondition", retrievalCondition);
            model.addAttribute("path","/touristRetrieval");
            model.addAttribute("title","游客信息检索");
        return "commonRetrieval";
    }

    @RequestMapping(value = "/page")
    public String byCondition(Model model, RetrievalCondition condition, @RequestParam int pageNum) {

        if(condition.getCondition() != null){
            retrievalCondition.setCondition(condition.getCondition());
            retrievalCondition.setValue(condition.getValue());
        }
        pageHandler.setPage(pageNum);

            list = new ArrayList<>();
            switch (retrievalCondition.getCondition()) {
                case "all": list = touristService.listPage();break;
                case "byName":
                    list.add(touristService.findByName(retrievalCondition.getValue()));

            }
            model.addAttribute("tourists", list);
            model.addAttribute("retrievalCondition", retrievalCondition);

        pageHandler.setModel(model,"/touristRetrieval/page");

        return "touristRetrieval";
    }


//    @RequestMapping("/detail/{id}")
//    public String detail(
//            @PathVariable("id") String name,
//            Model model) {
//        Info info = infoDao.findByName(name);
//        model.addAttribute(info);
//        return "infoDetail";
//    }
//
//    @RequestMapping(value = "/modify", method = POST)
//    public String modify(@Valid Info info, Errors errors) {
//        if (errors.asErrors())
//            return "infoDetail";
//        infoDao.update(info);h
//        return "redirect:/infoRetrieval";
//    }
}
