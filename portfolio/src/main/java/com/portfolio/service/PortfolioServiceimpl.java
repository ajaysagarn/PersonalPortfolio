package com.portfolio.service;

import com.ajsa.dyrepo.repository.node.model.Node;
import com.ajsa.dyrepo.repository.node.service.NodeCrudService;
import com.ajsa.dyrepo.repository.property.model.Property;
import com.ajsa.dyrepo.util.NodeMapper;
import com.ajsa.dyrepo.util.RepositoryException;
import com.portfolio.entity.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PortfolioServiceimpl implements PortfolioService{

    @Autowired
    NodeCrudService nodeCrudService;

    @Autowired
    NodeMapper nmapper;

    @Override
    public void initializePortfolio(String repoId) throws RepositoryException {

        nodeCrudService.createNode(repoId,"USERS",new ArrayList<>());
        Node menuRes = nodeCrudService.createNode(repoId,"MENUS",new ArrayList<>());


        nodeCrudService.createNode(menuRes.getNodeId(),"Introduction", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Introduction").build()).getProperties());
        nodeCrudService.createNode(menuRes.getNodeId(),"Work Experience", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Work Experience").build()).getProperties());
        nodeCrudService.createNode(menuRes.getNodeId(),"Education", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Education").build()).getProperties());
        nodeCrudService.createNode(menuRes.getNodeId(),"Projects", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Projects").build()).getProperties());
        nodeCrudService.createNode(menuRes.getNodeId(),"Contact", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Contact").build()).getProperties());
        nodeCrudService.createNode(menuRes.getNodeId(),"Content", (ArrayList<Property>) nmapper.toNode(Menu.builder().name("Content").build()).getProperties());

    }
}
