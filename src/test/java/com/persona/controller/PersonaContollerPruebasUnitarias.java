package com.persona.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;

@WebMvcTest(PersonaController.class)
public class PersonaContollerPruebasUnitarias {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private IPersonaService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@TestConfiguration
	static class TestConfig{
		@Bean
		IPersonaService personaService() {
			return Mockito.mock(IPersonaService.class);
		}
	}
	
	//PRUEBA UNITARIA DE: GET
//	
	
	/*
	@Test
	void testListarPersonas() throws Exception{
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Victor");
		p1.setTelefono("222");
		
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setNombre("Juan");
		p2.setTelefono("333");
		
		
		Mockito.when(service.listPersonas()).thenReturn(Arrays.asList(p1,p2));
		
		mockMvc.perform(get("/personas/listar")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].nombre").value("Victor")).andExpect(jsonPath("$[0].telefono").value("222"))
		.andExpect(jsonPath("$[1].nombre").value("Juan")).andExpect(jsonPath("$[1].telefono").value("333"));
		
	}
	*/
	
	
	/*
	@Test
	void testAgregarPersona() throws Exception{
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Victor");
		p1.setTelefono("2222");
		
		Mockito.when(service.savePersona(any(Persona.class))).thenReturn(p1);
		
		
		mockMvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(p1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nombre").value("Victor"))
		.andExpect(jsonPath("$.telefono").value("2222"));
	}
	*/
	
	
	/*
	@Test
	void testGetPersonaById() throws Exception{
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Victor");
		p1.setTelefono("2222");
		
		Mockito.when(service.getPerosnaById(1)).thenReturn(Optional.of(p1));
		
		
		mockMvc.perform(get("/personas/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.nombre").value("Victor"))
		.andExpect(jsonPath("$.telefono").value("2222"));
	}
	*/
	
	/*
	@Test
	void testGetPersonaByIdNotFound() throws Exception{
		
		
		Mockito.when(service.getPerosnaById(22))
		.thenReturn(Optional.empty());
		
		mockMvc.perform(get("/personas/22"))
		.andExpect(status().isNotFound());
		
	}
	*/
	
	/*
	
	@Test
	void testModificarPersona() throws Exception{
		
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Victor");
		p1.setTelefono("2222");
		
		Mockito.when(service.savePersona(any(Persona.class)))
		.thenReturn(p1);
		
		
		mockMvc.perform(put("/personas/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(p1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nombre").value("Victor"))
		.andExpect(jsonPath("$.telefono").value("2222"));
		
	}

	*/

	
	
	
	/*
	@Test
	void testDeletePersonaByIdFound() throws Exception{
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("Victor");
		p1.setTelefono("2222");
		
		Mockito.when(service.getPerosnaById(1)).thenReturn(Optional.of(p1));
		
		
		mockMvc.perform(delete("/personas/1"))
		.andExpect(status().isOk());
		
	}
	*/
	
	/*
	@Test
	void testDeletePersonaByIdNotFound() throws Exception{
		
		
		Mockito.when(service.getPerosnaById(22))
		.thenReturn(Optional.empty());
		
		mockMvc.perform(delete("/personas/22"))
		.andExpect(status().isNotFound());
		
	}
	*/
	
	

}
