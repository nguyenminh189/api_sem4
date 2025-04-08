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
        menu.setId(menuDTO.getId());
        menu.setDay_of_week(menuDTO.getDay_of_week());
        menu.setStart_date(menuDTO.getStart_date());
        menu.setEnd_date(menuDTO.getEnd_date());
        menu.setBreakfast(menuDTO.getBreakfast());
        menu.setSecond_breakfast(menuDTO.getSecond_breakfast());
        menu.setLunch(menuDTO.getLunch());
        menu.setDinner(menuDTO.getDinner());
        menu.setSecond_dinner(menuDTO.getSecond_dinner());
        return menuRepository.save(menu);
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
