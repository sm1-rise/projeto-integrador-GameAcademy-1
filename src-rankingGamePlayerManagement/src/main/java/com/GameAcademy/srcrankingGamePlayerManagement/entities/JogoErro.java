package com.GameAcademy.srcrankingGamePlayerManagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoErro {
    @NotNull(message = "Atributo codigoErro é obrigatório")
    private String codigoErro;
    @NotNull(message = "Atributo mensagem é obrigat")
    private String mensagem;
}
