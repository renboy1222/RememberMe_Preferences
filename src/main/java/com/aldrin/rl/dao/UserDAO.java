/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.rl.dao;

import com.aldrin.rl.model.User;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface UserDAO {


//    add User
    public void addUser(User user);

//    update User
    public void updateUser(User user);

//    delete User
    public void deleteUser(User user);

//    list of the User
    public List<User> selectUser();

    public User loginUser(User user);

    public Boolean changePassword(User user);

    public User findPhotoByUserId(User user);

 
}
