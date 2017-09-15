/*
package tm.controller;

import org.apache.tiles.preparer.ViewPreparer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import tm.pojo.PageParams;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/pageNum")
public class PageNumController extends SpringBeanPreparerFactory{
    private PageParams pageParams;
    private int begin;
    private int end;

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public ViewPreparer getViewPreparer(ServletContext sc){
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        return getPreparer("pageParams",context);
    }

    @RequestMapping(value = "/{num}",method = RequestMethod.GET)
    public String pageNum(Model model   ,@PathVariable("num") int num){
        pageParams.setPage(num);
        int totalPage = pageParams.getTotalPage();
        begin = 1;
        end = totalPage;
        if(num > 4){
            begin = num - 4;
        }
        if (num <= totalPage - 5) {
            end = num + 5;
        }
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("now",num);
        return "pageNum";
    }


}
*/
