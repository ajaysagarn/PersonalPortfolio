package com.portfolio.controller.api.v1;

import com.ajsa.dyrepo.util.RepositoryException;
import com.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PortfolioController {

    private PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/{repoId}/createPortfolioSite")
    public ResponseEntity initializePortfolio(@PathVariable String repoId) {
        try {
            portfolioService.initializePortfolio(repoId);
            return ResponseEntity.ok().body("Portfolio site created");
        } catch (RepositoryException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getErrorMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }

}
