package com.example.aihelper.goods;

public interface IGoodsService {

    Iterable<Goods> getAllGoods();

    Goods getGoods(long id);
}
