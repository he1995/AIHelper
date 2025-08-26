package com.example.aihelper.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderInfo, String> {
}
