package com.example.api_sem4.service;

import com.example.api_sem4.dto.MenuDTO;
import com.example.api_sem4.entity.Menu;
import com.example.api_sem4.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu saveMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setDate(menuDTO.getDate());
        menu.setBreakfast(menuDTO.getBreakfast());
        menu.setLunch(menuDTO.getLunch());
        menu.setDinner(menuDTO.getDinner());
        return menu;
    }

    public Menu updateMenu(MenuDTO menuDTO){
        Menu menu = saveMenu(menuDTO);
        return menuRepository.save(menu);
    }

    public void deleteMenu(Long id){
        menuRepository.deleteById(id);
    }

    public Optional<Menu> getMenuById(Long id){
        return menuRepository.findById(id);
    }
}
