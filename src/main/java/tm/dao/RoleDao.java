package tm.dao;

import org.springframework.stereotype.Repository;
import tm.pojo.Role;

import java.util.List;

@Repository
public interface RoleDao {
    void add(Role role);
    void delete(int id);
    void update(Role role);
    Role findByName(String role);
    Role findById(int id);
    List<Role> all();

    Role findByUser(int userId);
}
