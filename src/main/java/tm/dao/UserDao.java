package tm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tm.pojo.PageParams;
import tm.pojo.User;

import java.util.List;

@Repository
public interface UserDao {
    void add(User user);
    void delete(int id);
    void update(User user);
    User findByName(String username);
    User findById(int id);
    List<User> listAll();
    List<User> listPage(@Param("pageParams")PageParams pageParams);
}
