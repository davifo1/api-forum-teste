package io.davifo.forum.controller.dto;

public class TokenDTO {

    private String token;

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    private String type;

    public TokenDTO(String token, String type) {
        this.token = token;
        this.type = type;
    }
}
