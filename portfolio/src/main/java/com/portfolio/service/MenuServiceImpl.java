package com.portfolio.service;

import com.ajsa.dyrepo.repository.node.model.Node;
import com.ajsa.dyrepo.repository.node.model.NodeResponse;
import com.ajsa.dyrepo.repository.node.service.NodeCrudService;
import com.ajsa.dyrepo.repository.property.model.Property;
import com.ajsa.dyrepo.util.NodeMapper;
import com.ajsa.dyrepo.util.RepositoryException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.entity.menu.Menu;
import com.portfolio.util.PortfolioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private NodeCrudService nodeCrudService;

    @Autowired
    private NodeMapper nmapper;

    @Override
    public List<Menu> findAll(String repoId) throws RepositoryException, PortfolioException {
       Optional<NodeResponse> node =  nodeCrudService.readNode(repoId.concat("/MENUS"),1);
        if(node.isEmpty()){
            throw new PortfolioException(HttpStatus.NOT_FOUND.value(),"Menus node does not exist. please initialize a portfolio site");
        }
        List<Menu> menus = node.get().getChildren()
                .stream()
                .map(n -> nmapper.nodeToClass(n,Menu.class))
                .collect(Collectors.toList());

        return menus;
    }

    @Override
    public Optional<Menu> findById(String repoId, String id) {
        return Optional.empty();
    }

    @Override
    public Menu save(String repoid, Menu menu) {
        return null;
    }

    @Override
    public void deleteById(String repoId, String Id) {

    }
}
