package com.message.controller;

import javax.validation.Valid;

import com.message.dto.MessageDTO;
import com.message.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.message.response.Response;
import com.message.service.MessageService;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	MessageService service;

	@GetMapping
	public ResponseEntity<Response<String>> get(){

		Response<String> response = new Response<>();

		String message = "Estamos funcionando!";

		response.setData(message);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<MessageDTO>> create(@Valid @RequestBody MessageDTO dto, BindingResult result){
		
		Response<MessageDTO> response = new Response<MessageDTO>();


		if(result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		Message message = service.save(MessageDTO.fromDTO(dto));

		MessageDTO dtoResponse = MessageDTO.toDTO(message);

		response.setData(dtoResponse);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
}
