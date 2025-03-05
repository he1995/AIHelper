package com.example.aihelper.repository;

import com.example.aihelper.entity.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository  extends CrudRepository<ChatMessage, String> {
}
