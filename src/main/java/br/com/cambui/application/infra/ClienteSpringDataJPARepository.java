package br.com.cambui.application.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cambui.application.api.ClienteAlteracaoRequest;
import br.com.cambui.domain.Cliente;


public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
	Optional<Cliente> findByIdCliente(UUID idCliente);

}
