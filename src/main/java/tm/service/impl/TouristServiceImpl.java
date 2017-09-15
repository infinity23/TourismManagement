package tm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tm.dao.TouristDao;
import tm.pojo.PageParams;
import tm.pojo.Tourist;
import tm.service.TouristService;

import java.util.List;

@Service
@Transactional
public class TouristServiceImpl implements TouristService {
    private TouristDao touristDao;
    private PageParams pageParams;

    @Autowired
    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    @Autowired
    public void setTouristDao(TouristDao touristDao) {
        this.touristDao = touristDao;
    }

    @Override
    @CachePut(value = "touristCache", key = "#tourist.id")
    public void add(Tourist tourist){
        touristDao.add(tourist);
    }
    @Override
    public Tourist findByName(String touristName){
        return touristDao.findByName(touristName);
    }
    @Override
    @Cacheable(value = "touristCache", key = "#id")
    public Tourist findById(int id){
        return touristDao.findById(id);
    }
    @Override
    @CacheEvict(value = "touristCache", key = "#tourist.id")
    public void update(Tourist tourist){
        touristDao.update(tourist);
    }
    @Override
    @CacheEvict(value = "touristCache", key = "#id")
    public void delete(int id){
        touristDao.delete(id);
    }
    @Override
    public List<Tourist> listPage(){
        return touristDao.listPage(pageParams);
    }

    @Override
    public List<Tourist> listAll(){
        return touristDao.listAll();
    }
}
