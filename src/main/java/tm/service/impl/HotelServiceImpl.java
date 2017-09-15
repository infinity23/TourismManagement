package tm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tm.dao.HotelDao;
import tm.pojo.Hotel;
import tm.pojo.PageParams;
import tm.pojo.User;
import tm.service.HotelService;
import tm.service.UserService;

import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    private HotelDao hotelDao;
    private PageParams pageParams;
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setHotelDao(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Override
    @CachePut(value = "hotelCache", key = "#hotel.id")
    public void add(Hotel hotel) {
        hotelDao.add(hotel);
    }

    @Override
    public Hotel findByName(String hotelName) {
        return hotelDao.findByName(hotelName);
    }

    @Override
    @Cacheable(value = "hotelCache", key = "#id")
    public Hotel findById(int id) {
        return hotelDao.findById(id);
    }

    @Override
    public Hotel findByUserId(int userId) {
        return hotelDao.findByUserId(userId);
    }

    @Override
    @CacheEvict(value = "hotelCache", key = "#hotel.id")
    public void update(Hotel hotel) {
        hotelDao.update(hotel);
    }

    @Override
    @CacheEvict(value = "hotelCache", key = "#id")
    public void delete(int id) {
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> listPage() {
        return hotelDao.listPage(pageParams);
    }

    @Override
    public List<Hotel> listAll() {
        return hotelDao.listAll();
    }

    @Override
    public void registerHotel(Hotel hotel, User user) {
        userService.addHotel(user);
        hotel.setUserId(user.getId());
        hotelDao.registerHotel(hotel);
    }
}
