package com.GameAcademy.srcrankingGamePlayerManagement.exception;


import com.GameAcademy.srcrankingGamePlayerManagement.entities.JogoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JogoCustomException.class)
    public ResponseEntity<JogoErro> handleCatalogoCustomException (JogoCustomException e){
        JogoErro erroJogo = new JogoErro(e.getCodigoErro(), e.getMensagem());
        return ResponseEntity.status(e.getStatus()).body(erroJogo);
    }
}
