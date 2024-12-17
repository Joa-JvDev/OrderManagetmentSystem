package jva.dev.ordermanagetmentsystem.service;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import jva.dev.ordermanagetmentsystem.config.CacheConfig;
import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.model.Dish;
import jva.dev.ordermanagetmentsystem.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DishService{

    final String BASE_PROMT = "Teniendo en cuenta la lista de platillos proporcionada y el perfil del usuario, realiza lo siguiente:\n" +
            "Analiza el perfil del usuario para entender sus preferencias y restricciones. Luego, selecciona y recomienda un platillo de la lista " +
            "que mejor se ajuste al perfil del usuario. Proporciona el nombre del platillo y una breve explicación de por qué es la mejor opción " +
            "para este usuario.";

    private final ChatgptService chatgptService;
    private final DishRepository dishRepository;
    private final ConversionService conversionService;

    @Autowired
    public DishService(DishRepository dishRepository, ConversionService conversionService, ChatgptService chatgptService) {
        this.dishRepository = dishRepository;
        this.conversionService = conversionService;
        this.chatgptService = chatgptService;
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

    @Cacheable(value = CacheConfig.OBJECT_INFO_CACHE, unless = "#result == null")
    public List<Dish> getAllDish() {
        return dishRepository.findAll();
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    public String filterDishbyPerfil(String perfil) {
        List<Dish> dishes = dishRepository.findAll();

        String dishListString = dishes.stream()
                .map(dish -> dish.getName() + ": " + dish.getDescription())
                .reduce("", (partial, dish) -> partial + dish + "\n");

        String base = BASE_PROMT + " " +dishListString + " " + perfil;


        return chatgptService.sendMessage(base);

    }




    }


