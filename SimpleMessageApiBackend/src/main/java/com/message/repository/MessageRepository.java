package com.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.message.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	
}
