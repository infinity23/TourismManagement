package tm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tm.pojo.Hotel;
import tm.pojo.PageParams;

import java.util.List;

@Repository
public interface HotelDao {
    void add(Hotel hotel);
    void registerHotel(Hotel hotel);
    Hotel findByName(String hotelName);
    Hotel findById(int id);
    Hotel findByUserId(int userId);
    void update(Hotel hotel);
    void delete(int id);
    List<Hotel> listPage(@Param("pageParams") PageParams pageParams);
    List<Hotel> listAll();
}
