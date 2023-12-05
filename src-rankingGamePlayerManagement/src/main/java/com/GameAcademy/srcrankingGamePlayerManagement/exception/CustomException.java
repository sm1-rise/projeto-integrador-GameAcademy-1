package com.GameAcademy.srcrankingGamePlayerManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    private String codigoErro;
    private String mensagem;
    private Integer status;
}
