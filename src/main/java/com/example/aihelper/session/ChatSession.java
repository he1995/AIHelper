package com.example.aihelper.session;

import com.example.aihelper.mask.Mask;
import com.example.aihelper.message.ChatMessage;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class ChatSession {
    @Id
    private String id;

    private String topic;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ChatMessage> messages;

    private long createTime;

    private long lastUpdate;

    @OneToOne
    @JoinColumn(name = "mask_id", referencedColumnName = "id")
    private Mask mask;
}
