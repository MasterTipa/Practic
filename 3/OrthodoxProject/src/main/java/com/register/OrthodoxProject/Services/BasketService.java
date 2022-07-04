package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.BasketRepository;
import com.register.OrthodoxProject.TableInfo.Basket;
import com.register.OrthodoxProject.TableInfo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
private final BasketRepository basketRepository;
@Autowired
    public BasketService(BasketRepository basketRepository){this.basketRepository = basketRepository;}
    public List<Basket> getBasket(){return basketRepository.findAll();}
    public void addNewBasket(Basket basket){
    basketRepository.save(basket);
    }
public void deleteBasket(Long id){
    boolean exists =basketRepository.existsById(id);
    if(!exists){
        throw new IllegalStateException("Order with id: "+id+" does not exists");
    }
    else{
        basketRepository.deleteById(id);
        System.out.println("Client with id: "+id+" was delete");
    }
}
public void updateBasket(Long id, Order order_id){
    Basket basket = basketRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException("Order with id: "+id+" does not exists"));
    if (order_id!=null && basket.getOrder()!=order_id){
        basket.setOrder(order_id);
    }
}

}
