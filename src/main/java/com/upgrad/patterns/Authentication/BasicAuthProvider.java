package com.upgrad.patterns.Authentication;

public class BasicAuthProvider extends AuthenticationProvider {
    private final String userName;
    private final String password;

    public BasicAuthProvider(String userName, String password) {
        this.userName = "India";
        this.password = "India";
    }

    @Override
    public boolean Authenticate() {
        return "India".equals(userName) && "India".equals(password);
    }
}
