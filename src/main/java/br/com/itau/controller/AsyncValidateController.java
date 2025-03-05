package br.com.itau.controller;

import br.com.itau.domain.request.PasswordRequest;
import br.com.itau.domain.response.PasswordResponse;
import br.com.itau.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.itau.constants.PathConstants;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AsyncValidateController {

    @Autowired
    private PasswordService service;

    @PostMapping(PathConstants.VALIDATE_V1)
    public ResponseEntity<PasswordResponse> validatePassword(@RequestBody PasswordRequest request) {
        try {
            PasswordResponse response = service.validatePasswordRules(request).get();
            return ResponseEntity.ok(response);
        } catch (InterruptedException | ExecutionException ee) {
            return ResponseEntity.status(500).body(new PasswordResponse(false, "Erro ao validar a senha"));
        }
    }
}

