package com.message.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.message.utils.enums.MessageStatusEnum;
import lombok.Data;

@Entity
@Data
@Table(name="messages")
public class Message implements Serializable{

	private static final long serialVersionUID = 296956220496377784L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String message;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MessageStatusEnum status;

	@Column(name="created",nullable = false)
	private Date created;

	@Column(name="response_date")
	private Date responseDate;
	
	
}
