package tm.utils;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tm.pojo.PageParams;

@Component
public class PageViewPreparer implements ViewPreparer {
    private PageParams pageParams;

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        attributeContext.putAttribute("begin",new Attribute(1));
        attributeContext.putAttribute("end",new Attribute(pageParams.getTotalPage()));
        attributeContext.putAttribute("now",new Attribute(1));
//        attributeContext.putAttribute("page",new Attribute("/pageNum"));
    }
}
