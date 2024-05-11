/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.rl.util;

import com.aldrin.rl.model.User;

/**
 *
 * @author Java Programming with Aldrin
 */

public class LoginUser {
    private static User user;

    /**
     * @return the user
     */
    public static User getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(User aUser) {
        user = aUser;
    }
}
