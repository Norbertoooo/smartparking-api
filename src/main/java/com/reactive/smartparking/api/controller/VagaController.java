package com.reactive.smartparking.api.controller;

import com.reactive.smartparking.api.domain.Vaga;
import com.reactive.smartparking.api.service.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping
    private Flux<Vaga> listarTodasAsVagas() {
        return vagaService.findAll();
    }

    @GetMapping("/{id}")
    private Mono<Vaga> buscarVagaPorId(@PathVariable String id) {
        return vagaService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    private Flux<Vaga> buscarVagaPorNome(@PathVariable String nome) {
        return vagaService.findAllByNome(nome);
    }

    @GetMapping("/estado")
    private Flux<Vaga> vagasOcupadas() {
        return vagaService.vagasOcupadas();
    }

    @GetMapping("/nomes")
    private Flux<Object> listarNomes() {
        return vagaService.listaDeNomesDeVagasRegistradas();
    }

    @GetMapping("/estado/atual")
    private Flux<Object> listarEstadosAtuais() {
        return vagaService.estadoAtual();
    }

    @GetMapping("/estado/atual/{nome}")
    private Mono<Vaga> listarEstadoAtual(@PathVariable String nome) {
        return vagaService.estadoAtualPorVaga(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Vaga> salvarVaga(@Valid @RequestBody Vaga vaga) {
        return vagaService.save(vaga);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private Mono<Void> deletarTodasAsVagas() {
        return vagaService.deleteAll();
    }
}
