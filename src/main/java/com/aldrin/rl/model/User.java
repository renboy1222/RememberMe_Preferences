/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.rl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
@ToString
public class User {

    private Long id;

    private String firstname;
    private String surname;
    private String username;
    private String password;
    private Boolean active; 
    private byte[] photo;
    
    private Role role;

    public User() {

    }

}
