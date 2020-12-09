package com.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.menu.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String>{

}
