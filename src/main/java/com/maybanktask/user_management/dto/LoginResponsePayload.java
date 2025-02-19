package com.maybanktask.user_management.dto;


public class LoginResponsePayload {
    private String token;
    private String status;

    public LoginResponsePayload(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
