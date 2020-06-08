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

    @GetMapping("/id/{id}")
    private Mono<Vaga> buscarVagaPorId(@PathVariable String id) {
        return vagaService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    private Flux<Vaga> buscarVagaPorNome(@PathVariable String nome) {
        return vagaService.findAllByNome(nome);
    }

    @GetMapping("/nomes")
    private Flux<Object> listarNomes() {
        return vagaService.listaDeNomesDeVagasRegistradas();
    }

    @GetMapping("/estado")
    private Flux<Object> listarTodosEstadosAtuais() {
        return vagaService.estadoAtualDeCadaVaga();
    }

    @GetMapping("/estado/{nome}")
    private Mono<Vaga> listarEstadoAtualDeUmaVaga(@PathVariable String nome) {
        return vagaService.estadoAtualPorVaga(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Vaga> salvarUmaVaga(@Valid @RequestBody Vaga vaga) {
        return vagaService.saveOne(vaga);
    }

    @PostMapping("/lista-de-vagas")
    @ResponseStatus(HttpStatus.CREATED)
    private Flux<Vaga> salvarVariasVagas(@Valid @RequestBody Flux<Vaga> vagas) {
        return vagaService.saveMany(vagas);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private Mono<Void> deletarTudo() {
        return vagaService.deleteAll();
    }
}
