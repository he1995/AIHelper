package com.example.aihelper.message;

import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository  extends CrudRepository<ChatMessage, String> {
}
