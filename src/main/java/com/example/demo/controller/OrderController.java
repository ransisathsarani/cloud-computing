package com.example.demo.controller;

import com.example.demo.model.Food;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place Order
    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Check delivery Progress
    @GetMapping("/check-order-status")
    public ResponseEntity<Order> checkDeliveryProgress(@RequestParam(name = "orderId") int orderId) {
        Order order = orderService.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // List
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getOrders();

    }

    // Update Order Status
    @PatchMapping("/order-status")
    public ResponseEntity<Order> updateOrderStatus(@RequestParam(name = "orderId") int orderId, @RequestBody Order order) {
        Order updatedOrderStatus = orderService.updateStatus(orderId, order);
        return new ResponseEntity<>(updatedOrderStatus, HttpStatus.OK);
    }
}
