package br.com.itau.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class PasswordRequest{
        @NotBlank(message = "O campo nome é obrigatório")
        @Size(min = 9, message = "A senha deve ter no mínimo 9 caracteres")
        @Schema(description = "Senha do usuário", example = "P@ssw0rd!", required = true)
        private String password;
}
