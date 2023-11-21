package com.GameAcademy.srcrankingGamePlayerManagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoErro {
    private String status;
    private String mensagem;
}
