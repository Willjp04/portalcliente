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

import java.util.List;

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



}
