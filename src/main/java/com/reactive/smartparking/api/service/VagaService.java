package com.reactive.smartparking.api.service;

import com.reactive.smartparking.api.domain.Vaga;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VagaService {
    Flux<Vaga> findAll();
    Mono<Vaga> findById(String id);
    Flux<Vaga> findAllByNome(String nome);
    Mono<Vaga> saveOne(Vaga vaga);
    Flux<Vaga> saveMany(Flux<Vaga> vagas);
    Mono<Void> deleteAll();
    Mono<Vaga> statusAtualPorVaga(String vaga);

    // TODO: 30/05/2020 converter Flux<Object> to Flux<Vaga>
    Flux<Object> listaDeNomesDeVagasRegistradas();
    Flux<Object> statusAtualDeCadaVaga();
}
