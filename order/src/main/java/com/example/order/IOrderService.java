package com.example.order;

public interface IOrderService {
    void createOrder(OrderInfo orderInfo);
    void cancelOrder(String orderId);
}
