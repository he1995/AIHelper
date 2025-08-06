package com.example.aihelper.mask;

import com.example.aihelper.message.ChatMessage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Mask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String avatar;

    private String name;

    @OneToMany(mappedBy = "mask", cascade = CascadeType.PERSIST)
    private List<ChatMessage> context;
}
