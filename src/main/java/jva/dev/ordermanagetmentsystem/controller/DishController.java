package jva.dev.ordermanagetmentsystem.controller;

import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.model.Dish;
import jva.dev.ordermanagetmentsystem.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dish")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DishDTO> createDish(@RequestBody DishDTO dishDTO) {
        DishDTO createdDish = dishService.createDish(dishDTO);
        return new  ResponseEntity<>(createdDish,HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<DishDTO> updateDish(@PathVariable Long id, @RequestBody DishDTO dish) {
        DishDTO updatedDish = dishService.updateDish(id, dish);
        return new ResponseEntity<>(updatedDish,HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Dish>> getAllDish() {
        return new ResponseEntity<>(dishService.getAllDish(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }

    @GetMapping(value = "/perfil")
    public String filterDishbyPerfil(String perfil) {
        return dishService.filterDishbyPerfil(perfil);

    }

}
