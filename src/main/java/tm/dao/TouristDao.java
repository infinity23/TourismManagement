package tm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tm.pojo.PageParams;
import tm.pojo.Tourist;

import java.util.List;

@Repository
public interface TouristDao {
    void add(Tourist tourist);
    Tourist findByName(String touristName);
    Tourist findById(int id);
    void update(Tourist tourist);
    void delete(int id);
    List<Tourist> listPage(@Param("pageParams") PageParams pageParams);
    List<Tourist> listAll();
}
