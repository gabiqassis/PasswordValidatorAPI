package br.com.itau.domain.response;

public record PasswordResponse(
    boolean valid,
    String message
){}

