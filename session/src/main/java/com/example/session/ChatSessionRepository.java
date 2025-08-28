package com.example.session;

import org.springframework.data.repository.CrudRepository;

public interface ChatSessionRepository extends CrudRepository<ChatSession, String> {
}
