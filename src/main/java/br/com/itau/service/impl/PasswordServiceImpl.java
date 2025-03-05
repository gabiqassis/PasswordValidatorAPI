package br.com.itau.service.impl;

import br.com.itau.domain.model.Password;
import br.com.itau.domain.request.PasswordRequest;
import br.com.itau.domain.response.PasswordResponse;
import br.com.itau.service.PasswordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final Password password;

    @Override
    public CompletableFuture<PasswordResponse> validatePasswordRules(PasswordRequest request) {
        log.info("Iniciando validação de senha");

        try {
            password.rulesPassword(request);
            log.info("Validação da senha concluída com sucesso");
            return CompletableFuture.completedFuture(new PasswordResponse(true, "A senha atende a todas as regras."));
        } catch (IllegalArgumentException e) {
            log.error("Erro ao validar senha: {}", e.getMessage());
            return CompletableFuture.completedFuture(new PasswordResponse(false, e.getMessage()));
        }
    }
}

