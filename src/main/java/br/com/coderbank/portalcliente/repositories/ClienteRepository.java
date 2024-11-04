package br.com.coderbank.portalcliente.repositories;

import br.com.coderbank.portalcliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
