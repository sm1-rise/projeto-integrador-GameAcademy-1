package com.GameAcademy.srcrankingGamePlayerManagement.exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MensagemErro> handleDataIntegrationViolationException(DataIntegrityViolationException e) {
        MensagemErro mensagemErro = new MensagemErro(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MensagemErro> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        MensagemErro mensagemErro = new MensagemErro(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), e.getMethod());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(mensagemErro);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MensagemErro> handlerNoSuchElementException(NoSuchElementException e) {
        MensagemErro mensagemErro = new MensagemErro(HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<MensagemErro> handlerEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        MensagemErro mensagemErro = new MensagemErro(HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
    }

   // @ExceptionHandler(Exception.class)
   // public ResponseEntity<MensagemErro> handlerUnexpected(Exception e) {
   //     MensagemErro mensagemErro = new MensagemErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Erro inesperado");
   //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagemErro);
   // }
}