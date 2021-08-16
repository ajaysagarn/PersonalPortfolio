package com.portfolio.util;

import com.ajsa.dyrepo.util.RepositoryException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PortfolioException extends Exception {
    public int status;
    public PortfolioException.Message errorMessage;

    public PortfolioException(int status, String message){
        this.status = status;
        this.errorMessage = new PortfolioException.Message(status,message);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Message{
        int status;
        String message;
    }
}
