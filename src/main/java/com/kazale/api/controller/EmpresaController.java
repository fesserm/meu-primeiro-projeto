package com.kazale.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kazale.api.dto.EmpresaDTO;
import com.kazale.api.response.Response;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

	@GetMapping(value = "/{nome}")
	public String exemplo(@PathVariable("nome") String nome) {
		return "Olá : "+nome;
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDto, BindingResult result){
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		return ResponseEntity.ok(response);
	}
}
