package tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import tm.dao.AuthorityDao;
import tm.dao.RoleDao;
import tm.dao.UserDao;
import tm.pojo.Authority;
import tm.pojo.Role;
import tm.pojo.User;

import java.util.List;

public interface UserService {
    @Autowired
    void setUserDao(UserDao userDao);

    @Autowired
    void setRoleDao(RoleDao roleDao);

    @Autowired
    void setAuthorityDao(AuthorityDao authorityDao);

    void add(User user);

    void addAdmin(User user);

    void addHotel(User user);

    void delete(int id);

    void update(User user);

    User findByName(String name);

    User findById(int id);

    List<User> listAll();

    List<User> listPage();

    List<Authority> authorities(int id);

    Role role(int id);
}
