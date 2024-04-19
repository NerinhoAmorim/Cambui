package br.com.cambui.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v/1cliente")
public interface ClienteAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse clienteResponse(@Valid @RequestBody ClienteRequest clienteRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteListResponse> getTodosClientes();
	
	@GetMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteDetalhadoResponse getClientesAtravesDoId(@PathVariable UUID idCliente);
	
	@DeleteMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaClienteAtravesDoId(@PathVariable UUID idCliente);
	
	@PatchMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraCliente(@PathVariable UUID idCliente,
			@Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);

	
}
