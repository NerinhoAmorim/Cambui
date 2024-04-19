package br.com.cambui.application.service;

import java.util.List;
import java.util.UUID;

import br.com.cambui.application.api.ClienteAlteracaoRequest;
import br.com.cambui.application.api.ClienteDetalhadoResponse;
import br.com.cambui.application.api.ClienteListResponse;
import br.com.cambui.application.api.ClienteRequest;
import br.com.cambui.application.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente( ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClienteAtravesDoId(UUID idCliente);
	void deletaClienteAtravesDoId(UUID idCliente);
	void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);

}
