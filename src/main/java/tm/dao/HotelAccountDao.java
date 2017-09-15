package tm.dao;

import org.springframework.stereotype.Repository;
import tm.pojo.HotelAccount;

@Repository
public interface HotelAccountDao {
    void add(HotelAccount hotelAccount);
    void update(HotelAccount hotelAccount);
    HotelAccount findByName(String name);
    void delete(int hotelId);
}
