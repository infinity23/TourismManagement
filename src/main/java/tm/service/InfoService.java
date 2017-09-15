package tm.service;

import tm.pojo.Info;

import java.util.List;

public interface InfoService {

    void add(Info info);

    List<Info> listPage();

    List<Info> listAll();

    List<Info> listPageByHotel(String userName);

    List<Info> listAllByHotel(String userName);
}
