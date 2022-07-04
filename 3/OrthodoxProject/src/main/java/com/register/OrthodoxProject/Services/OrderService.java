package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.OrderRepository;
import com.register.OrthodoxProject.TableInfo.Cafe;
import com.register.OrthodoxProject.TableInfo.Client;
import com.register.OrthodoxProject.TableInfo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
private final OrderRepository orderRepository;
@Autowired
    public OrderService(OrderRepository orderRepository){
    this.orderRepository = orderRepository;
}
    public List<Order> getOrder(){return orderRepository.findAll();}
    public void addNewOrder(Order order){
       /* Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        if (optionalOrder.isPresent()) {System.out.println("Jopa");
        }else{*/
    orderRepository.save(order);
}
    public void deleteOrder(Long id){
    boolean exists =orderRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Order with id: "+id+" does not exists");
        }
        else{
            orderRepository.deleteById(id);
            System.out.println("Client with id: "+id+" was delete");
        }
    }
    public void updateOrder(Long id, Cafe cafe_id, Client client_id, Double bill, Integer table_number){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Order with id: "+id+" does not exists"));
        if (cafe_id!=null && order.getCafe()!=cafe_id){
            order.setCafe(cafe_id);
        }
        if (client_id!=null && order.getClient()!=client_id){
            order.setClient(client_id);
        }
        if(bill!=null && bill>0 &&
                order.getBill()!=bill
        ){
            order.setBill(bill);
        }
        if(table_number!=null && table_number>0 &&
                order.getTableNumber()!=table_number
        ){
            order.setTableNumber(table_number);
        }
}
}
