package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tm.pojo.Info;
import tm.pojo.RetrievalCondition;
import tm.service.InfoService;
import tm.utils.PageHandler;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/infoRetrieval")
public class InfoRetrievalController{
    private InfoService infoService;
    private List<Info> list;
    private PageHandler pageHandler;
    private RetrievalCondition retrievalCondition;

    @Autowired
    public void setRetrievalCondition(RetrievalCondition retrievalCondition) {
        this.retrievalCondition = retrievalCondition;
    }

    @Autowired
    public void setPageHandler(PageHandler pageHandler) {
        this.pageHandler = pageHandler;
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String infoRetrieval(Model model){
            model.addAttribute(retrievalCondition);
            model.addAttribute("path","/infoRetrieval");
            model.addAttribute("title","入住信息检索");
        return "commonRetrieval";
    }

    @RequestMapping("/page")
    public String byCondition(Model model,RetrievalCondition condition, @RequestParam int pageNum){
        if(condition.getCondition() != null){
            retrievalCondition.setCondition(condition.getCondition());
            retrievalCondition.setValue(condition.getValue());
        }
            pageHandler.setPage(pageNum);
            list = new ArrayList<>();
             switch (retrievalCondition.getCondition()) {
            case "all":
                list = infoService.listPage();break;
        }
            model.addAttribute("infoList", list);
            pageHandler.setModel(model,"/infoRetrieval/page");

        return "infoRetrieval";
    }

}
