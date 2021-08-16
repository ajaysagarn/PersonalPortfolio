package com.portfolio.controller.api.v1;

import java.util.List;

import com.ajsa.dyrepo.util.RepositoryException;
import com.portfolio.service.MenuService;
import com.portfolio.util.PortfolioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.menu.Menu;
import com.portfolio.dao.MenuDao;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("{repoId}/getMenus")
	public ResponseEntity getAllMenus(@PathVariable String repoId) {
		try {
			List<Menu> menus = menuService.findAll(repoId);
			return ResponseEntity.ok().body(menus);
		} catch (RepositoryException e) {
			return ResponseEntity.status(e.getStatus()).body(e.getErrorMessage());
		} catch (PortfolioException e) {
			return ResponseEntity.status(e.getStatus()).body(e.getErrorMessage());
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
	}
	
	@GetMapping("{repoId}/getMenu/{id}")
	public Menu getMenuById(@PathVariable String repoId, @PathVariable String id) {
		return menuService.findById(repoId, id).orElse(null);
	}
	
	@PostMapping("{repoId}/createMenu")
	public Menu createMenu(@PathVariable String repoId, @RequestBody Menu menu) {
		return menuService.save(repoId, menu);
	}
	
	@DeleteMapping("{repoId}/deleteMenu/{id}")
	public void deleteMenu(@PathVariable String repoId ,@PathVariable("id") String menuId) {
		menuService.deleteById(repoId, menuId);
	}
	
	@PutMapping("{repoId}/addMenuItem/{id}")
	public Menu updateMenu(@PathVariable String repoId,@PathVariable("id") String menuId,@RequestBody Menu menu) {
		menu.setId(menuId);
		return menuService.save(repoId,menu);
	}
	
}
