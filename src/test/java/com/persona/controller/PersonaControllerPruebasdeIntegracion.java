package com.persona.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.PublicKey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.persona.modelo.Persona;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaControllerPruebasdeIntegracion {

	@Autowired
	private MockMvc mockMvc;
	
	
	
	@BeforeEach
	public void setup() {
		
		
	}
		/*
		 * INICIALIZAR O CARGAR LA BD, LIMPIAR LA BD, CREAR UNA BD DE PRUEBA, ETC.....
		 */
		
	/*
		
		@Test
		public void testListatPersonas() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/personas/listar"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
		
	}
	*/
		
		/*
		@Test
		public void testAgregarPersona() throws Exception{
			Persona persona = new Persona();
			persona.setNombre("carlos");
			persona.setTelefono("2222");
			
			
			mockMvc.perform(MockMvcRequestBuilders.post("/personas")
					.contentType("application/json")
					.content("{\"nombre\":\"carlos\",\"telefono\":\"2222\"}"))
			.andExpect(status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath(".nombre").value("carlos"))
			.andExpect(MockMvcResultMatchers.jsonPath(".telefono").value("2222"));
			
			
		}
 		*/
	/*
	@Test
	public void testGetPersonaById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/personas/1"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		
	}
	
	*/
	
	/*
	@Test 
	public void tetsModificarPersona() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/personas/1")
				.contentType("application/json")
				.content("{\"nombre\":\"carlos\",\"telefono\":\"2222\"}"))
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath(".nombre").value("carlos"))
		.andExpect(MockMvcResultMatchers.jsonPath(".telefono").value("2222"));
	}
	*/
	
	@Test
	public void testEliminarPersona() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/personas/1"))
		.andExpect(status().isOk());
		
	}
 		
}
