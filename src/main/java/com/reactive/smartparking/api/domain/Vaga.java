package com.reactive.smartparking.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document @NoArgsConstructor @AllArgsConstructor @Data
public class Vaga {
    @Id
    private String id;

    @NotNull(message = "Nome deve ser preenchido")
    private String nome;

    @NotNull(message = "Estado da vaga deve ser preenchido")
    private boolean estado;

    private Date data = new Date();
}
