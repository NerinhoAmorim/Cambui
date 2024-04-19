package br.com.cambui.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.cambui.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
	private final ClienteService clienteService;

	@Override
	public ClienteResponse clienteResponse(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getTodosClientes() {
		log.info("[inicia] ClienteController - getTodosClientes");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[inicia] ClienteController - getTodosClientes");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getClientesAtravesDoId(UUID idCliente) {
		log.info("[inicia] ClienteController - getClientesAtravesDoId");
		log.info("[idCliente] {}", idCliente);
		ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClienteAtravesDoId(idCliente);
		log.info("[inicia] ClienteController - getClientesAtravesDoId");
		return clienteDetalhado;
	}

	@Override
	public void deletaClienteAtravesDoId(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClienteAtravesDoId");
		log.info("[idCliente] {}", idCliente);
		clienteService.deletaClienteAtravesDoId(idCliente);
		log.info("[finaliza] ClienteController - deletaClienteAtravesDoId");
		
	}

	@Override
	public void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteController - patchClienteAtravesDoId");
		log.info("[idCliente] {}", idCliente);
		clienteService.patchAlteraCliente(idCliente, clienteAlteracaoRequest);
		log.info("[finaliza] ClienteController - patchClienteAtravesDoId");
		
	}

	

}
