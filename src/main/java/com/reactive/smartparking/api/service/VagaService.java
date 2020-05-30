package com.reactive.smartparking.api.service;

import com.reactive.smartparking.api.domain.Vaga;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VagaService {
    Flux<Vaga> findAll();
    Mono<Vaga> findById(String id);
    Flux<Vaga> findAllByNome(String nome);
    Mono<Vaga> save(Vaga vaga);
    Mono<Void> deleteAll();
    Flux<Vaga> vagasOcupadas();
    Flux<Object> listaDeNomesDeVagasRegistradas();
    Flux<Object> estadoAtual();
    Mono<Vaga> estadoAtualPorVaga(String vaga);
}
