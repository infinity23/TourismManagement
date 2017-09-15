package tm.service;

import tm.pojo.Tourist;

import java.util.List;

public interface TouristService {
    void add(Tourist tourist);

    Tourist findByName(String touristName);

    Tourist findById(int id);

    void update(Tourist tourist);

    void delete(int id);

    List<Tourist> listPage();

    List<Tourist> listAll();
}
