package tm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tm.dao.AuthorityDao;
import tm.dao.RoleDao;
import tm.dao.UserDao;
import tm.dao.UserRoleDao;
import tm.pojo.*;
import tm.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;
    private AuthorityDao authorityDao;
    private PageParams pageParams;
    private UserRoleDao userRoleDao;
    private UserRole userRole;

    //加密相关
    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();


    @Autowired
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Override
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Autowired
    public void setAuthorityDao(AuthorityDao authorityDao) {
        this.authorityDao = authorityDao;
    }

    @Override
    @CachePut(value = "userCache", key = "#user.id")
    public void add(User user){
        userDao.add(user);
    }

    @Override
    @CachePut(value = "userCache", key = "#user.id")
    public void addAdmin(User user) {
        String passwd = passwordEncoder.encodePassword(user.getPassword(), user.getUsername());
        user.setPassword(passwd);
        userDao.add(user);
        userRole.setUserId(user.getId());
        userRole.setRoleId(1);
        userRoleDao.add(userRole);
    }

    @Override
    @CachePut(value = "userCache", key = "#user.id")
    public void addHotel(User user) {
        String passwd = passwordEncoder.encodePassword(user.getPassword(), user.getUsername());
        user.setPassword(passwd);
        userDao.add(user);
        userRole.setUserId(user.getId());
        userRole.setRoleId(2);
        userRoleDao.add(userRole);
    }

    @Override
    @CacheEvict(value = "userCache", key = "#id")
    public void delete(int id){
        userDao.delete(id);
    }
    @Override
    @CacheEvict(value = "userCache", key = "#user.id")
    public void update(User user){
        userDao.update(user);
    }
    @Override
    public User findByName(String name){
        return userDao.findByName(name);
    }
    @Override
    @Cacheable(value = "userCache", key = "#id")
    public User findById(int id){
        return userDao.findById(id);
    }
    @Override
    public List<User> listAll(){
        return userDao.listAll();
    }
    @Override
    public List<User> listPage(){
        return userDao.listPage(pageParams);
    }

    @Override
    public List<Authority> authorities(int id){
        int roleId = roleDao.findByUser(id).getId();
        return authorityDao.findByRole(roleId);
    }

    @Override
    @Cacheable(value = "userCache", key = "'role' + #id")
    public Role role(int id){
        return roleDao.findByUser(id);
    }
}
