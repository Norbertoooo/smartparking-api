package com.reactive.smartparking.api.service.impl;

import com.reactive.smartparking.api.domain.Vaga;
import com.reactive.smartparking.api.repository.VagaRepository;
import com.reactive.smartparking.api.service.VagaService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VagaServiceImpl implements VagaService {

    private final VagaRepository vagaRepository;

    public VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Override
    public Flux<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    @Override
    public Mono<Vaga> findById(String id) {
        return vagaRepository.findById(id);
    }

    @Override
    public Flux<Vaga> findAllByNome(String nome) {
        return vagaRepository.findAllByNomeOrderByDataAsc(nome);
    }

    @Override
    public Mono<Vaga> save(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    @Override
    public Mono<Void> deleteAll() {
        return vagaRepository.deleteAll();
    }

    @Override
    public Flux<Vaga> vagasOcupadas() {
        return vagaRepository.findVagasByEstadoIsTrueOrderByDataAsc().distinct(Vaga::getNome);
    }

    @Override
    public Flux<Object> listaDeNomesDeVagasRegistradas() {
        return vagaRepository.findAll().distinct(Vaga::getNome).map(Vaga::getNome);
    }

    @Override
    public Flux<Object> estadoAtual() {
        return vagaRepository.findAll().distinct(Vaga::getNome).flatMap(vaga -> (estadoAtualPorVaga(vaga.getNome())));
    }

    @Override
    public Mono<Vaga> estadoAtualPorVaga(String vaga) {
        return vagaRepository.findDistinctByNomeOrderByDataAsc(vaga).last();
    }
}
