package br.com.cambui.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cambui.application.api.ClienteAlteracaoRequest;
import br.com.cambui.application.api.ClienteDetalhadoResponse;
import br.com.cambui.application.api.ClienteListResponse;
import br.com.cambui.application.api.ClienteRequest;
import br.com.cambui.application.api.ClienteResponse;
import br.com.cambui.application.repository.ClienteRepository;
import br.com.cambui.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesDoId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClienteAtravesDoId");
		log.info("[idCliente] {}", idCliente);
		Cliente cliente = clienteRepository.buscaClienteAtravesDoId(idCliente);
		log.info("[finaliza] ClienteApplicationService - buscaClienteAtravesDoId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClienteAtravesDoId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - deletaClienteAtravesDoId");
		log.info("[idCliente] {}", idCliente);
		Cliente cliente = clienteRepository.buscaClienteAtravesDoId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaClienteAtravesDoId");
		
	}

	@Override
	public void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteApplicationService - patchAlteraCliente");
		Cliente cliente = clienteRepository.buscaClienteAtravesDoId(idCliente);
		cliente.altera(clienteAlteracaoRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza] ClienteApplicationService - patchAlteraCliente");

		
	}

}
