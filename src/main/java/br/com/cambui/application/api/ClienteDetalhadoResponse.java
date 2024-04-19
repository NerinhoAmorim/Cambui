package br.com.cambui.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.cambui.domain.Cliente;
import br.com.cambui.domain.Sexo;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String telefone;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String cpf;
	private Boolean aceitaTermos;

	private LocalDateTime dataHoraDoCadastro;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.celular = cliente.getCelular();
		this.telefone = cliente.getTelefone();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpf = cliente.getCpf();
		this.aceitaTermos = cliente.getAceitaTermos();
		this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
	}

}
