package com.GameAcademy.srcrankingGamePlayerManagement.exception;


import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.JogoErro;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<JogoErro> handleDataIntegrationViolationException(DataIntegrityViolationException e) {
        JogoErro jogoErro = new JogoErro(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jogoErro);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<JogoErro> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        JogoErro jogoErro = new JogoErro(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), e.getMethod());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(jogoErro);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<JogoErro> handlerNoSuchElementException(NoSuchElementException e) {
        JogoErro jogoErro = new JogoErro(HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jogoErro);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<JogoErro> handlerEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        JogoErro jogoErro = new JogoErro(HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jogoErro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JogoErro> handlerUnexpected(Exception e) {
        JogoErro jogoErro = new JogoErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Erro inesperado");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jogoErro);
    }
}


/*@ExceptionHandler(JogoCustomException.class)
    public ResponseEntity<JogoErro> handleCatalogoCustomException(JogoCustomException e) {
        JogoErro jogoErro = new JogoErro(e.getCodigoErro(), e.getMensagem());
        return ResponseEntity.status(e.getStatus()).body(jogoErro);
    }

     */
