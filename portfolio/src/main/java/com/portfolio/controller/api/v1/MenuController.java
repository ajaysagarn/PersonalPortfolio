package com.portfolio.controller.api.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.menu.Menu;
import com.portfolio.repository.MenuRepository;

@RestController
@RequestMapping("/api/v1")
public class MenuController {
	
	private final MenuRepository menuRepository;

	@Autowired
	public MenuController(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	@GetMapping("/getMenus")
	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}
	
	@GetMapping("/getMenu/{id}")
	public Menu getMenuById(@PathVariable String id) {
		return menuRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/createMenu")
	public Menu createMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}
	
	@DeleteMapping("/deleteMenu/{id}")
	public void deleteMenu(@PathVariable("id") String menuId) {
		menuRepository.deleteById(menuId);
	}
	
	@PutMapping("/addMenuItem/{id}")
	public Menu updateMenu(@PathVariable("id") String menuId,@RequestBody Menu menu) {
		menu.setId(menuId);
		return menuRepository.save(menu);
	}
	
}
