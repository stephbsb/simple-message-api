package com.message.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.message.entity.Message;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

@Data
public class MessageDTO {

    private Long id;

    @NotNull(message = "Insira uma nome")
    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    @Email(message="Email Inválido.")
    private String email;


    @Length(min = 10, message = "Mensagem deve ter no minimo 10 caracteres")
    private String message;

    public static Message fromDTO(MessageDTO dto) {
        Message u = new Message();
        u.setId(dto.getId());
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u.setMessage(dto.getMessage());

        return u;
    }


    public static MessageDTO toDTO(Message u) {
        MessageDTO dto = new MessageDTO();
        dto.setId(u.getId());
        dto.setEmail(u.getEmail());
        dto.setName(u.getName());
        dto.setMessage(u.getMessage());

        return dto;
    }

}
