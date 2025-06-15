package com.ecommerce.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice // Trata a exceção RequisicaoInvalida
public class GlobalExceptionHandler {

    // Trata exceção personalizada quando a requisição é inválida (ex: campos
    // obrigatórios ausentes)
    @ExceptionHandler(RequisicaoInvalida.class)
    public ResponseEntity<Object> handleBadRequest(RequisicaoInvalida ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Requisição inválida");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // Trata exceção quando o usuário envia credenciais erradas (ex: login/senha
    // inválidos)
    @ExceptionHandler(CredenciaisInvalidas.class)
    public ResponseEntity<Object> handleUnauthorized(CredenciaisInvalidas ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Credenciais inválidas");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}