package com.example.aihelper.order;

public record OrderRequest(
        String name,
        String email,
        String price,
        String delivery,
        String payMethod,
        String username){}