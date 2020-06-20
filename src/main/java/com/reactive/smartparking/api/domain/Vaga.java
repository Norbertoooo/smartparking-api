package com.reactive.smartparking.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Document @NoArgsConstructor @AllArgsConstructor @Data
public class Vaga {

    @Id
    private String id;

    @NotBlank(message = "Nome deve ser preenchido")
    private String nome;

    private StatusVaga status;

    private OffsetDateTime data = OffsetDateTime.now(ZoneId.of("UTC+03:00"));
}
