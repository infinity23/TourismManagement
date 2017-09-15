package tm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tm.pojo.Info;
import tm.pojo.PageParams;

import java.util.List;

@Repository
public interface InfoDao{
    void add(Info info);
    List<Info> listPage(@Param("pageParams")PageParams pageParams);
    List<Info> listAll();
    List<Info> listPageByHotel(@Param("hotelId") int hotelId,@Param("pageParams")PageParams pageParams);
    List<Info> listAllByHotel(int hotelId);
}