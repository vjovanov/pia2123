/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

/**
 *
 * @author Administrator
 */
public class UserData {

    private int kId = 0;
    private String username = null;
    private String password = null;
    private String name = null;
    private String lastname = null;
    private String email = null;
    private String title = null;
    private int isAdmin = 0;
    
        public UserData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getKId() {
        return kId;
    }

    public void setKId(int kId) {
        this.kId = kId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
