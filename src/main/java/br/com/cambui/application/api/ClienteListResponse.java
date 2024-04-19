package br.com.cambui.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.cambui.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String celular;
	private String email;

	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteListResponse :: new)
				.collect(Collectors.toList());
	}

	private ClienteListResponse(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
	}
		
	}


