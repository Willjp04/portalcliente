package br.com.coderbank.portalcliente.services;

import br.com.coderbank.portalcliente.dtos.requests.ClienteRequestDTO;
import br.com.coderbank.portalcliente.dtos.responses.ClienteResponseDTO;
import br.com.coderbank.portalcliente.entities.Cliente;
import br.com.coderbank.portalcliente.entities.enums.Status;
import br.com.coderbank.portalcliente.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO salvar(final ClienteRequestDTO clienteRequestDTO) {

        var clienteEntity = new Cliente();

        BeanUtils.copyProperties(clienteRequestDTO, clienteEntity);
        clienteEntity.setStatus(Status.ATIVO);

        clienteRepository.save(clienteEntity);

        return new ClienteResponseDTO
                (clienteEntity.getId(),
        clienteEntity.getStatus(),
        clienteEntity.getCriadoPeloUsuario(),
        clienteEntity.getCriadoDataEHora(),
        null,
        null
                        );


    }
}