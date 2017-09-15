package tm.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.dao.HotelDao;
import tm.dao.InfoDao;
import tm.dao.TouristDao;
import tm.pojo.Hotel;
import tm.pojo.Info;
import tm.pojo.Tourist;
import tm.service.HotelService;
import tm.service.InfoService;
import tm.service.TouristService;
import tm.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("hotel/checkIn")
public class CheckInController {
    private Info info;
    private SqlSession sqlSession;
    private HotelDao hotelDao;
    private TouristDao touristDao;
    private InfoDao infoDao;
    private List<Hotel> hotelList;
    private List<Tourist> touristList;
    private HotelService hotelService;
    private InfoService infoService;
    private TouristService touristService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @Autowired
    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @Autowired
    public void setTouristList(List<Tourist> touristList) {
        this.touristList = touristList;
    }

    @Autowired
    public void setInfo(Info info) {
        this.info = info;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String checkIn(Model model) {
        model.addAttribute(info);
        return "checkIn";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(Info info, HttpSession session) {
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String userName = securityContextImpl.getAuthentication().getName();
        info.setCheckIn(Calendar.getInstance().getTime());
        int userId = userService.findByName(userName).getId();
        info.setHotelId(hotelService.findByUserId(userId).getId());
        touristService.add(info.getTourist());
        info.setTouristId(info.getTourist().getId());
        infoService.add(info);

        return "redirect:/hotel/checkQuery";
    }


}
