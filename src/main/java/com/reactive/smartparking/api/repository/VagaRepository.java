package com.reactive.smartparking.api.repository;

import com.reactive.smartparking.api.domain.Vaga;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VagaRepository extends ReactiveMongoRepository<Vaga, String> {
    Flux<Vaga> findAllByNomeOrderByDataAsc(String nome);
    Flux<Vaga> findDistinctByNomeOrderByDataAsc(String nome);
}
