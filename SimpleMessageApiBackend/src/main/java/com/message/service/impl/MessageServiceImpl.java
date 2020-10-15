package com.message.service.impl;

import com.message.entity.Message;
import com.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.service.MessageService;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageRepository repository;
	
	@Override
	public Message save(Message message) {

		Date created_date = new Date(System.currentTimeMillis());

		message.setCreated(created_date);

		return repository.save(message);
	}

}
