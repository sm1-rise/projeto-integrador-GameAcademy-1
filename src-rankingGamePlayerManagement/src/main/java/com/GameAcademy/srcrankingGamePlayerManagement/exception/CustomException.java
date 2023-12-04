package com.GameAcademy.srcrankingGamePlayerManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private String codigoErro;
    private String mensagem;
    private Integer status;
}
