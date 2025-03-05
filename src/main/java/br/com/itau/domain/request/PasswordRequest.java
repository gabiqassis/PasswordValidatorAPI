package br.com.itau.domain.request;

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
        @Size(max = 9, message = "A senha deve ter no máximo 9 caracteres")
        private String password;
}
