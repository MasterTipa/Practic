package com.register.OrthodoxProject.Controllers;

import com.register.OrthodoxProject.Services.BasketService;
import com.register.OrthodoxProject.TableInfo.Basket;
import com.register.OrthodoxProject.TableInfo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    private final BasketService basketService;
    @Autowired
    public BasketController(BasketService basketService){this.basketService=basketService;}
    @GetMapping
    public List<Basket> getBasket(){return basketService.getBasket();}
    @PostMapping
    public void registerNewBasket(@RequestBody Basket basket){
        basketService.addNewBasket(basket);
    }
    @DeleteMapping(path = "{id}")
    public void deleteBasket(
            @PathVariable("id") Long id){
        basketService.deleteBasket(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateBasket(
            @PathVariable("id") Long id,
            @RequestParam(required = false)Order order_id){
        basketService.updateBasket(id, order_id);
    }
}
