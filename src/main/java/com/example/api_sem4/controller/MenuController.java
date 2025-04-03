package com.example.api_sem4.controller;

import com.example.api_sem4.dto.MenuDTO;
import com.example.api_sem4.entity.Menu;
import com.example.api_sem4.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping()
    public ResponseEntity<Menu> addMenu(@RequestBody MenuDTO menuDTO) {
        Menu savedMenu = menuService.saveMenu(menuDTO);
        return ResponseEntity.ok(savedMenu);
    }

    @GetMapping()
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {
        Optional<Menu> existingMenu = menuService.getMenuById(id);
        if (existingMenu.isPresent()) {
            menuDTO.setId(id);  // Set the ID of the menu to update
            Menu updatedMenu = menuService.saveMenu(menuDTO);
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        Optional<Menu> existingMenu = menuService.getMenuById(id);
        if (existingMenu.isPresent()) {
            menuService.deleteMenu(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}