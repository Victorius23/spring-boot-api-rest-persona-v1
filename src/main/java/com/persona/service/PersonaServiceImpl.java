package com.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persona.modelo.Persona;
import com.persona.repository.PeronsaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private PeronsaRepository repository;

	@Override
	public List<Persona> listPersonas() {
		return (List<Persona>) repository.findAll();
	}

	@Override
	public Optional<Persona> getPerosnaById(int id) {
		return repository.findById(id);
	}

	@Override
	public Persona savePersona(Persona persona) {
		repository.save(persona);
		return persona;
	}

	@Override
	public void deletePersona(int id) {
		repository.deleteById(id);
		
	}
	
	
	
	

}
