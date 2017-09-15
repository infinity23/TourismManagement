package tm.dao;

import org.springframework.stereotype.Repository;
import tm.pojo.Authority;

import java.util.List;

@Repository
public interface AuthorityDao {
    void add(Authority authority);
    void delete(int id);
    void update(Authority authority);
    AuthorityDao findByName(String name);
    AuthorityDao findById(int id);
    List<Authority> all();

    List<Authority> findByRole(int roleId);
}
