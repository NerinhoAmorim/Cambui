package br.com.cambui.application.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.cambui.application.api.ClienteAlteracaoRequest;
import br.com.cambui.application.repository.ClienteRepository;
import br.com.cambui.domain.Cliente;
import br.com.cambui.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salva");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
		List<Cliente> clientes = clienteSpringDataJPARepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
		return clientes;
	}

	@Override
	public Cliente buscaClienteAtravesDoId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClienteAtravesDoId");
		Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
				.orElseThrow(()-> APIException.build(HttpStatus.NO_CONTENT, "Cliente não encontrado!"));
		log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravesDoId");
		return cliente;
	}

	@Override
	public void deletaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - deletaCliente");
		clienteSpringDataJPARepository.delete(cliente);
		log.info("[inicia] ClienteInfraRepository - deletaCliente");
		
	}

	@Override
	public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteInfraRepository - altera");
		log.info("[finaliza] ClienteInfraRepository - altera");
		
	}

	

	

}
