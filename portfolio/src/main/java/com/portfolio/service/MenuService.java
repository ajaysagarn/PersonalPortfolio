package com.portfolio.service;

import com.ajsa.dyrepo.util.RepositoryException;
import com.portfolio.entity.menu.Menu;
import com.portfolio.util.PortfolioException;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> findAll(String repoId) throws RepositoryException, PortfolioException;
    Optional<Menu> findById(String repoId, String id);
    Menu save(String repoid, Menu menu);
    void deleteById(String repoId, String Id);
}
