package com.portfolio.dao;

import com.ajsa.dyrepo.repository.node.service.NodeCrudService;
import com.ajsa.dyrepo.repository.node.service.NodeCrudServiceImpl;
import com.portfolio.entity.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MenuDaoImpl implements MenuDao{


    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public Optional<Menu> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Menu save(Menu menu) {




        return null;
    }

    @Override
    public void deleteById(String Id) {

    }
}
