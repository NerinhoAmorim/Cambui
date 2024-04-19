package br.com.cambui.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.cambui.application.api.ClienteAlteracaoRequest;
import br.com.cambui.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClienteAtravesDoId(UUID idCliente);
	void deletaCliente(Cliente cliente);
	void altera(ClienteAlteracaoRequest clienteAlteracaoRequest);

}
