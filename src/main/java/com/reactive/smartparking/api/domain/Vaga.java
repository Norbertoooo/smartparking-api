package com.reactive.smartparking.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Document @NoArgsConstructor @AllArgsConstructor @Data
public class Vaga {
    @Id
    private String id;

    @NotNull(message = "Nome deve ser preenchido")
    private String nome;

    @NotNull(message = "Estado da vaga deve ser preenchido")
    private boolean status;

    private String data = new Date()
            .toInstant()
            .atZone(ZoneId.of("Brazil/East"))
            .format(DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss"));
    // TODO: 06/06/2020 refatorar essa data como string, deveria estar usando um tipo espefico para data/hora com zoneId
}
