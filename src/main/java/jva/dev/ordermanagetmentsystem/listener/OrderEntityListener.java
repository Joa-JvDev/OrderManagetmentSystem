package jva.dev.ordermanagetmentsystem.listener;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jva.dev.ordermanagetmentsystem.enums.OrderStatus;
import jva.dev.ordermanagetmentsystem.model.Dish;
import jva.dev.ordermanagetmentsystem.model.Order;
import jva.dev.ordermanagetmentsystem.service.OrderService;

import java.time.Duration;
import java.time.LocalDateTime;

public class OrderEntityListener {

    @PrePersist
    public void prePersist(Order order) {
        LocalDateTime now = LocalDateTime.now();
        order.setOrderDate(now);

        Double price = 0.0;
        for (Dish dish : order.getDishes()) {
            price += dish.getPrice();
        }
        order.setTotal(price);
    }

    @PostLoad
    public void postLoad(Order order) {
        if (order.getOrderDate() != null) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.ofMinutes(2);
            LocalDateTime endTime = order.getOrderDate().plus(duration);

            if (now.isAfter(endTime)) {
                order.setStatus(OrderStatus.IN_PROGRESS);
            } else {
                order.setStatus(OrderStatus.PENDING);
            }
        }
    }


    //1. @PreUpdate
    //Se ejecuta antes de que un objeto sea actualizado en la base de datos.
    //
    //2. @PostUpdate
    //Se ejecuta después de que un objeto sea actualizado en la base de datos.
    //
    //3. @PreRemove
    //Se ejecuta antes de que un objeto sea eliminado de la base de datos.

}


