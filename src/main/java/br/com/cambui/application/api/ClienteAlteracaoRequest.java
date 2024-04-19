package br.com.cambui.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.cambui.domain.Sexo;
import lombok.Value;

@Value
public class ClienteAlteracaoRequest {
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitaTermos;

}
