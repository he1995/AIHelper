package com.example.aihelper.message;

import com.example.aihelper.session.ChatSession;
import com.example.aihelper.mask.Mask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChatMessage {
    @Id
    private String id;

    private String role;

    @Column(length = 2000)
    private String content;

    private String date;

    @ManyToOne
    @JoinColumn(name = "mask_id")
    @JsonIgnore
    private Mask mask;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonIgnore
    private ChatSession session;
}
