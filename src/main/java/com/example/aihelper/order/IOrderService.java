package com.example.aihelper.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    void createOrder(OrderInfo orderInfo);
    void cancelOrder(String orderId);
}
