package com.sytoss.edu2021.models;

import lombok.ToString;
import javax.persistence.*;

@Entity(name="app_user")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    @Column(name="user_name")
    private String userName;
}
