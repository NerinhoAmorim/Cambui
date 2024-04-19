package br.com.cambui.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorApiResponse {
private String message;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String description;

}
