package tm.service;

import tm.pojo.Hotel;
import tm.pojo.User;

import java.util.List;

public interface HotelService {
    void add(Hotel hotel);

    Hotel findByName(String hotelName);

    Hotel findById(int id);

    Hotel findByUserId(int userId);

    void update(Hotel hotel);

    void delete(int id);

    List<Hotel> listPage();

    List<Hotel> listAll();

    void registerHotel(Hotel hotel, User user);
}
