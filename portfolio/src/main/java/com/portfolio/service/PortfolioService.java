package com.portfolio.service;

import com.ajsa.dyrepo.util.RepositoryException;

public interface PortfolioService {

    void initializePortfolio(String repoId) throws RepositoryException;

}
