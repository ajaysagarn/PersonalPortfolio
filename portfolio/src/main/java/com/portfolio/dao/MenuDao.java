package com.portfolio.dao;


import com.portfolio.entity.menu.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuDao {

    List<Menu> findAll();
    Optional<Menu> findById(String id);
    Menu save(Menu menu);
    void deleteById(String Id);

}
