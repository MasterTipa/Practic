package com.register.OrthodoxProject.Controllers;

import com.register.OrthodoxProject.Services.OrderService;
import com.register.OrthodoxProject.TableInfo.Cafe;
import com.register.OrthodoxProject.TableInfo.Client;
import com.register.OrthodoxProject.TableInfo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "order")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){this.orderService=orderService;}
    @GetMapping
    public List<Order> getOrder(){return orderService.getOrder();}
    @PostMapping
    public void registerNewOrder(@RequestBody Order order){
        orderService.addNewOrder(order);
    }
    @DeleteMapping(path = "{id}")
    public void deleteOrder(
            @PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateOrder(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Cafe cafe_id,
            @RequestParam(required = false) Client client_id,
            @RequestParam(required = false) Double bill,
            @RequestParam(required = false) Integer table_number
            ){
        orderService.updateOrder(id,cafe_id,client_id,bill,table_number);
    }
}
