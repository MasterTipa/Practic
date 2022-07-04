package com.register.OrthodoxProject.Controllers;

import com.register.OrthodoxProject.Services.DishService;
import com.register.OrthodoxProject.TableInfo.Basket;
import com.register.OrthodoxProject.TableInfo.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "dish")
public class DishController {
    private final DishService dishService;
    @Autowired
    public DishController(DishService  dishService){this.dishService=dishService;}
    @GetMapping
    public List<Dish> getDish(){return dishService.getDish();}
    @PostMapping
    public  void registerNewDish(@RequestBody Dish dish){dishService.addNewDish(dish);}
    @DeleteMapping(path = "{id}")
    public void deleteDish(
            @PathVariable("id") Long id){
        dishService.deleteDish(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateDish(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Basket basket_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double cost){
        dishService.updateDish(id,basket_id,name,cost);
    }
}
