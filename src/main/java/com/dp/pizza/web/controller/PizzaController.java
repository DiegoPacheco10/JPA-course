package com.dp.pizza.web.controller;

import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.entity.PizzaEntity;
import com.dp.pizza.service.PizzaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")

public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<PizzaDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaDTO> getAll(@PathVariable String idPizza) {
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    @PostMapping("/add")
    public ResponseEntity<PizzaDTO> add(@RequestBody PizzaDTO dto) {

        if (dto.id() == null || !this.pizzaService.exists(dto.id())){

            return ResponseEntity.ok(this.pizzaService.save(dto));

        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<PizzaDTO> update(@RequestBody PizzaDTO dto) {
        if (dto.id() != null && this.pizzaService.exists(dto.id())){
            return ResponseEntity.ok(this.pizzaService.save(dto));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete (@PathVariable String idPizza){

        if (idPizza != null && this.pizzaService.exists(idPizza)){
            this.pizzaService.delete(idPizza);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/getAvailable")
    public ResponseEntity<Page<PizzaDTO>> getAvailablePizza(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "8") int elements,
                                                            @RequestParam(defaultValue = "price" ) String sortBy,
                                                            @RequestParam(defaultValue = "ASC" ) String sortDirection){
        return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<PizzaDTO>> getPizzaByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

}