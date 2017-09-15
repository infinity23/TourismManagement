package tm.dao;

import org.springframework.stereotype.Repository;
import tm.pojo.UserRole;

import java.util.List;

@Repository
public interface UserRoleDao {
    void add(UserRole userRole);
    void delete(int userId);
    void update(UserRole userRole);
    UserRole find(int userId) ;
    List<UserRole> all();
}
