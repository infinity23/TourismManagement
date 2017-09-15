package tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tm.pojo.Info;
import tm.service.InfoService;
import tm.utils.PageHandler;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/hotel/checkQuery")
public class CheckQueryController {
    private InfoService infoService;
    private List<Info> infoList;
    private PageHandler pageHandler;

    @Autowired
    public void setPageHandler(PageHandler pageHandler) {
        this.pageHandler = pageHandler;
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String checkQuery(Model model, @RequestParam int pageNum, HttpSession session) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String userName = securityContextImpl.getAuthentication().getName();
        pageHandler.setPage(pageNum);
        infoList = infoService.listPageByHotel(userName);
        model.addAttribute("infoList", infoList);
        pageHandler.setModel(model,"/hotel/checkQuery");
        return "checkQuery";
    }
}
