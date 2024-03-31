package com.example.virus.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "token_tb")
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String token;
    private boolean isLoggedOut;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

