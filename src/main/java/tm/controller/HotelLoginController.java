/*
package tm.controller;

import mybatis.config.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tm.dao.HotelAccountDao;
import tm.pojo.HotelAccount;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/hotelLogin")
public class HotelLoginController {
    private HotelAccount hotelAccount;
    private HotelAccount result;
    private SqlSession sqlSession;
    private HotelAccountDao hotelAccountDao;
    private String errors;

    @Autowired
    public void setHotelAccount(HotelAccount hotelAccount) {
            this.hotelAccount = hotelAccount;
        }

    @RequestMapping(method = RequestMethod.GET)
    public String hotelLogin(Model model){
        model.addAttribute(hotelAccount);
        return "hotelLogin";
    }
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(HotelAccount hotelAccount, Model model, HttpSession session){
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            hotelAccountDao = sqlSession.getMapper(HotelAccountDao.class);
            result = hotelAccountDao.findByName(hotelAccount.getName());
            sqlSession.commit();
            if(result == null){
                errors = "用户名不存在";
                model.addAttribute(hotelAccount);
                model.addAttribute(errors);
                return "/hotelLogin";
            }else if (!result.getPasswd().equals(hotelAccount.getPasswd())){
                errors = "密码错误";
                model.addAttribute(hotelAccount);
                model.addAttribute(errors);
                return "/hotelLogin";
            }
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        session.setAttribute("hotelId",result.getHotelId());
        return "redirect:/hotel";
    }
}
*/
