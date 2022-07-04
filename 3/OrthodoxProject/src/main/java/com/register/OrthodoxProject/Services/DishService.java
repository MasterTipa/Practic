package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.DishRepository;
import com.register.OrthodoxProject.TableInfo.Basket;
import com.register.OrthodoxProject.TableInfo.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishService {
    private final DishRepository dishRepository;
    @Autowired
    public DishService(DishRepository dishRepository){this.dishRepository=dishRepository;}
    public List<Dish> getDish(){return dishRepository.findAll();}
    public void deleteDish(Long id) {
        boolean exists = dishRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Dish with id: "+id+" does not exists");
        }
    else{
        dishRepository.deleteById(id);
            System.out.println("Dish with id: "+id+" was delete");
        }
    }
    public void addNewDish(Dish dish) {
    dishRepository.save(dish);
    }
    public void updateDish(Long id, Basket basket_id, String name, Double cost) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Dish with id: "+id+" does not exists"));
        if (basket_id!=null && dish.getBasket()!=basket_id){
            dish.setBasket(basket_id);
        }
        if (name!=null && dish.getName()!=name){
            dish.setName(name);
        }
        if (cost!=null && dish.getCost()!=cost){
            dish.setCost(cost);
        }
    }
}
