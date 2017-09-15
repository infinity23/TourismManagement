package tm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tm.dao.HotelDao;
import tm.dao.InfoDao;
import tm.dao.UserDao;
import tm.pojo.Info;
import tm.pojo.PageParams;
import tm.service.InfoService;

import java.util.List;

@Service
@Transactional
public class InfoServiceImpl implements InfoService {
    private InfoDao infoDao;
    private PageParams pageParams;
    private UserDao userDao;
    private HotelDao hotelDao;

    @Autowired
    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Autowired
    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Override
    public void add(Info info){
        infoDao.add(info);
    }
    @Override
    public List<Info> listPage(){
        return infoDao.listPage(pageParams);
    }
    @Override
    public List<Info> listAll(){ return infoDao.listAll();}
    @Override
    public List<Info> listPageByHotel(String userName){
        int userId = userDao.findByName(userName).getId();
        int hotelId = hotelDao.findByUserId(userId).getId();
        return infoDao.listPageByHotel(hotelId,pageParams);
    }
    @Override
    public List<Info> listAllByHotel(String userName){
        int userId = userDao.findByName(userName).getId();
        int hotelId = hotelDao.findByUserId(userId).getId();
        return infoDao.listAllByHotel(hotelId);
    }
}
