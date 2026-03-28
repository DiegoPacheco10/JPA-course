package com.dp.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@IdClass(com.platzi.pizza.persitence.entity.OrderItemId.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, nullable = false)
    private String id;

    @Id
    @Column(name = "id_order", length = 36, nullable = false)
    private String idOrder;

    @Column(name = "id_pizza", length = 36, nullable = false)
    private String idPizza;

    // Using BigDecimal to support DECIMAL(2,1)
    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal quantity;

    // Using BigDecimal to support DECIMAL(5,2)
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id", insertable = false, updatable = false)
    private PizzaEntity pizza;

}