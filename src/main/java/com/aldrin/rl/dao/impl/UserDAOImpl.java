/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.rl.dao.impl;


import com.aldrin.rl.dao.UserDAO;
import com.aldrin.rl.model.Role;
import com.aldrin.rl.model.User;
import com.aldrin.rl.util.LoginUser;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class UserDAOImpl extends DBConnection implements UserDAO {

    @Override
    public void addUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO USER (FIRSTNAME,SURNAME,USERNAME,PASSWORD,ROLE_ID,PHOTO,ACTIVE) VALUES  (?,?,?,?,?,?,?,?) ");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getRole().getId());
            ps.setBytes(6, user.getPhoto());
            ps.setBoolean(7, user.getActive());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE USER SET FIRSTNAME =?, SURNAME =?, USERNAME=?, PASSWORD=?, ROLE_ID=?, PHOTO=? ,ACTIVE =? WHERE USER.ID = ?");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getRole().getId());
            ps.setBytes(6, user.getPhoto());
            ps.setBoolean(7, user.getActive());
            ps.setLong(8, user.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE USER SET ACTIVE =? WHERE USER.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, user.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public ArrayList<User> selectUser() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "    USER.ID, \n"
                    + "    USER.ACTIVE, \n"
                    + "    USER.FIRSTNAME, \n"
                    + "    USER.PASSWORD, \n"
                    + "    USER.SURNAME, \n"
                    + "    USER.USERNAME, \n"
                    + "    USER.ROLE_ID, \n"
                    + "    ROLE.ROLE \n"
                    + "FROM \n"
                    + "    USER \n"
                    + "INNER JOIN \n"
                    + "    ROLE \n"
                    + "ON \n"
                    + "    ( \n"
                    + "        USER.ROLE_ID = ROLE.ID)  ORDER BY ROLE.ROLE ASC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                User u = new User();
                Role r = new Role();
                r.setId(rs.getLong("ROLE_ID"));
                r.setRole(rs.getString("ROLE"));
                u.setId(rs.getLong("ID"));
                u.setRole(r);
                u.setFirstname(rs.getString("FIRSTNAME"));
                u.setSurname(rs.getString("SURNAME"));
                u.setUsername(rs.getString("USERNAME"));
                u.setPassword(rs.getString("PASSWORD"));
                u.setActive(rs.getBoolean("ACTIVE"));

                list.add(u);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public User findPhotoByUserId(User user) {
        User userPhoto = new User();
        Blob photo = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT  PHOTO FROM USER  WHERE ID  =" + user.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("PHOTO");
                photo = picturel;
                byte[] bytes = convertBlobToBytes(picturel);
                userPhoto.setPhoto(bytes);
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return userPhoto;
    }

    private static byte[] convertBlobToBytes(java.sql.Blob blob) throws IOException, SQLException {
        try (InputStream inputStream = blob.getBinaryStream()) {
            return convertInputStreamToBytes(inputStream);
        }
    }

    private static byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    private static void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
        }
    }

    @Override
    public User loginUser(User user) {
        User userInfo = null;
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(null);
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    USER.FIRSTNAME, \n"
                    + "    USER.ACTIVE, \n"
                    + "    USER.ID, \n"
                    + "    USER.ROLE_ID, \n"
                    + "    ROLE.ROLE, \n"
                    + "    USER.PASSWORD, \n"
                    + "    USER.SURNAME, \n"
                    + "    USER.USERNAME ,USER.PHOTO\n"
                    + "FROM \n"
                    + "    USER \n"
                    + "INNER JOIN \n"
                    + "    ROLE \n"
                    + "ON \n"
                    + "    (USER.ROLE_ID = ROLE.ID) WHERE USER.USERNAME =BINARY '" + user.getUsername() + "' AND USER.PASSWORD =BINARY '" + user.getPassword() + "' AND USER.ACTIVE =true");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User ua = new User();
                
                Role r = new Role();
                Long userId = rs.getLong("ID");
                Long roleId = rs.getLong("ROLE_ID");
                String firstname = rs.getString("FIRSTNAME");
                String surname = rs.getString("SURNAME");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");
                boolean active = rs.getBoolean("ACTIVE");
                Blob picturel = rs.getBlob("PHOTO");
                byte[] bytes = convertBlobToBytes(picturel);
                ua.setPhoto(bytes);
                r.setId(roleId);
                r.setRole(role);
                ua.setRole(r);
                ua.setId(userId);
                ua.setFirstname(firstname);
                ua.setSurname(surname);
                ua.setUsername(username);
                ua.setPassword(password);
                ua.setActive(active);
                userInfo = ua;
                loginUser.setUser(ua);
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }

        return userInfo;
    }

    @Override
    public Boolean changePassword(User user) {
        Boolean changePassword = false;
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE USER SET  PASSWORD=?  WHERE USER.ID = ?");
            ps.setString(1, user.getPassword());
            ps.setLong(2, user.getId());
            ps.execute();
            ps.close();
            closeConnection();
            changePassword = true;
            LoginUser loginUser = new LoginUser();
            loginUser.getUser().setPassword(user.getPassword());
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        return changePassword;

    }






}
