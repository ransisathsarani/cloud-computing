package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("not found"));
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order updateStatus(int orderId, Order order) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("not found"));
        existingOrder.setStatus(order.getStatus());
        orderRepository.save(existingOrder);
        return existingOrder;
    }
}
