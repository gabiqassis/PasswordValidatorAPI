package br.com.itau.domain.model;

import br.com.itau.domain.request.PasswordRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.regex.Pattern;

@Component
public class Password {
    @Schema(
            description = "Senha do usuário. Deve conter pelo menos 9 caracteres, um número, uma letra maiúscula, uma letra minúscula, um caractere especial e não possuir caracteres repetidos.",
            example = "P@ssw0rd!",
            format = "password"
    )
    private String password;

    private static final String SPECIAL_CHARACTER_REGEX = "[!@#$%^&*(),.?\":{}|<>]";
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile(SPECIAL_CHARACTER_REGEX);

    public void rulesPassword(PasswordRequest passwordRequest) {
        validateContainsDigit(passwordRequest.getPassword());
        validateContainsLowercase(passwordRequest.getPassword());
        validateContainsUppercase(passwordRequest.getPassword());
        validateContainsSpecialCharacter(passwordRequest.getPassword());
        validateNoRepeatedCharacters(passwordRequest.getPassword());
    }

    private void validateContainsDigit(String password) {
        if (!DIGIT_PATTERN.matcher(password).find()) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um número.");
        }
    }

    private void validateContainsLowercase(String password) {
        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra minúscula.");
        }
    }

    private void validateContainsUppercase(String password) {
        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
    }

    private void validateContainsSpecialCharacter(String password) {
        if (!SPECIAL_CHARACTER_PATTERN.matcher(password).find()) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um caractere especial (ex.: !@#$%^&*).");
        }
    }

    private void validateNoRepeatedCharacters(String password) {
        HashSet<Character> characterSet = new HashSet<>();
        for (char c : password.toCharArray()) {
            if (!characterSet.add(c)) {
                throw new IllegalArgumentException("A senha não deve conter caracteres repetidos.");
            }
        }
    }
}
