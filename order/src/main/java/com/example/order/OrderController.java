package com.example.order;

import com.example.common.constants.Constants;
import com.example.common.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("create")
    public ResponseResult<OrderInfo> createOrder(@RequestBody OrderRequest orderRequest)
    {
        //时间戳_用户ID
        String userId = redisTemplate.opsForValue().get(Constants.USER_ID);
        String orderId = System.currentTimeMillis() + "_" + userId;
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setEmail(orderRequest.email());
        orderInfo.setPayMethod(orderRequest.payMethod());
        orderInfo.setName(orderRequest.name());
        orderInfo.setPrice(orderRequest.price());
        orderInfo.setDelivery(orderRequest.delivery());
        orderInfo.setCreateTime(new Date().toString());
        orderInfo.setStatus(OrderStatus.UNPAID);
        orderInfo.setUsername(orderRequest.username());
        orderService.createOrder(orderInfo);

        log.info("{}:订单：【{}】创建成功",new Date(), orderId);
        //10 seconds expire for testing
        redisTemplate.opsForValue().set(orderId, "1",10, TimeUnit.MINUTES);

        return ResponseResult.success(orderInfo);
    }
}
