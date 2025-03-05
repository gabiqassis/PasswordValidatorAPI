package br.com.itau.service;

import br.com.itau.domain.request.PasswordRequest;
import br.com.itau.domain.response.PasswordResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface PasswordService {

    CompletableFuture<PasswordResponse> validatePasswordRules(PasswordRequest request);
}
