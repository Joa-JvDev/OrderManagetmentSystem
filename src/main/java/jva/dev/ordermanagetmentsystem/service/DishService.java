package jva.dev.ordermanagetmentsystem.service;

import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.model.Dish;
import jva.dev.ordermanagetmentsystem.repository.DishRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DishService{

    DishRepository dishRepository;
    ConversionService conversionService;

    @Autowired
    public DishService(DishRepository dishRepository, ConversionService conversionService) {
        this.dishRepository = dishRepository;
        this.conversionService = conversionService;
    }

    @Transactional(timeout = 1)
    public DishDTO createDish(DishDTO dishDto) {
        Dish newDish = conversionService.convert(dishDto, Dish.class);
        Dish createdDish = dishRepository.save(Objects.requireNonNull(newDish));

        return conversionService.convert(createdDish,DishDTO.class);
    }

    public DishDTO updateDish(Long id,DishDTO dish) {
        Dish findDish = dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Dish not found"));

        findDish.setName(dish.getName());
        findDish.setDescription(dish.getDescription());
        findDish.setPrice(dish.getPrice());

        Dish updatedDish = dishRepository.save(findDish);
        return conversionService.convert(updatedDish,DishDTO.class);
    }

    public List<Dish> getAllDish() {
        return dishRepository.findAll();
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

}
