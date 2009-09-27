/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

/**
 *
 * @author Administrator
 */
public class RequestData {
    private int zId = 0;
    private String username = null;
    private String password = null;
    private String name = null;
    private String lastname = null;
    private String email = null;
    private String title = null;
    private String requestDate = null;
    private String decisionDate = null;

    public RequestData() {
        this.zId = 0;
        this.username = null;
        this.password = null;
        this.name = null;
        this.lastname = null;
        this.email = null;
        this.title = null;
        this.requestDate = null;
        this.decisionDate = null;

    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
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

    public int getZId() {
        return zId;
    }

    public void setZId(int zId) {
        this.zId = zId;
    }


}
