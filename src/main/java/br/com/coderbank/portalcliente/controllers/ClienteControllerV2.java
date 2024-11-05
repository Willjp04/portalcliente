package br.com.coderbank.portalcliente.controllers;

import br.com.coderbank.portalcliente.dtos.requests.ClienteRequestDTO;
import br.com.coderbank.portalcliente.dtos.responses.ClienteResponseDTO;
import br.com.coderbank.portalcliente.entities.Cliente;
import br.com.coderbank.portalcliente.repositories.ClienteRepository;
import br.com.coderbank.portalcliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v2/clientes")
public class ClienteControllerV2 {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar (@RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(clienteRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Cliente>> buscarPorId(@PathVariable UUID id) {

        var cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null) {
            return ResponseEntity.ok(Collections.singletonList(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")

    public ResponseEntity<Cliente> atualizar(@PathVariable(value = "id") UUID id, @RequestBody Cliente cliente) {

        var clienteOptional = clienteRepository.findById(id);
        return clienteOptional
                .map(c -> ResponseEntity.ok
                        (clienteRepository.save(cliente))).orElseGet(() -> ResponseEntity.notFound().build());
    }

        @DeleteMapping("/{id}")
                public ResponseEntity<Void> remover(@PathVariable UUID id){
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
