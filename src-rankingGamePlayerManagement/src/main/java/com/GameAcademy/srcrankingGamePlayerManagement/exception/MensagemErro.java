package com.GameAcademy.srcrankingGamePlayerManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErro {
    @NotNull(message = "Atributo codigoErro é obrigatório")
    private String codigoErro;
    @NotNull(message = "Atributo mensagem é obrigatório")
    private String mensagem;
}