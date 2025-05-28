package CRUD.livraria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) { // Método para tratar exceções RuntimeException
        return ResponseEntity.badRequest().body(ex.getMessage()); // Retorna Bad Request com a mensagem da exceção
    }
}
