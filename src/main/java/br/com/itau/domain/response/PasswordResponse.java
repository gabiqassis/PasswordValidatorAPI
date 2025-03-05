package br.com.itau.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record PasswordResponse(
    @Schema(description = "Indica se a senha é válida", required = true)
    boolean valid,
    @Schema(description = "Mensagem de erro ou sucesso", required = true)
    String message
){}

