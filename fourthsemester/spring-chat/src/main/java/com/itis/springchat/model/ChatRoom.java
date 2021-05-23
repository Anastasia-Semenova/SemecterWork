package com.itis.springchat.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "rooms")
@Entity
@Data
public class ChatRoom {
    @Id
    @GeneratedValue
    private int id;

    private String user1Id;

    private String user2Id;
}
