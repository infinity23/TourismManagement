package tm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import tm.pojo.PageParams;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PageHandler {
    private PageParams pageParams;
    private int num;

    @Autowired
    public PageHandler(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public void setPage(int num){
        this.num = num;
        pageParams.setPage(num);
    }

    public void setModel(Model model, String path){
        int totalPage = pageParams.getTotalPage();
        int begin = 1;
        int end = totalPage;
        if(num > 4){
            begin = num - 4;
        }
        if (num <= totalPage - 5) {
            end = num + 5;
        }
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("now",num);
        model.addAttribute("path",path);
    }
}
