package com.itis.springchat.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "message")
@Entity
@Data
public class ChatMessage {
    @Id
    @GeneratedValue
    private int id;

    private String message;

    private String senderId;

    private String recipientId;

    @ManyToOne(fetch = FetchType.EAGER)
    private ChatRoom chatRoom;

    private Date date;
}
