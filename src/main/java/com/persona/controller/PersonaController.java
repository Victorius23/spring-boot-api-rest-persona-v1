package com.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





/*

    API/ MICROSERVICIOS

    VERBOS, RECURSOS: GET, PUT, DELETE, POST
                      SELECT, UPDATE, DELETE, INSERT

    ENDPOINTS/RECURSOS: URI HTTP

    <SERVER><PORT><WEBAPP><NAMESPACE><ACTION>

    http://localhost:7575/personas/listar

*/

/*

CrossOrigin: Enlazar el proyecto backend(API REST) con el proyecto frontend(Angular, Puerto 4200)

*/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)//permitir el acceso desde angular
@RequestMapping("personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    //ENDPONT, METHOD GET: http://localhost:7575/personas/listar
    @GetMapping("listar")
    public List<Persona> listaPersonas() {
        List<Persona> personas = (List<Persona>) service.listPersonas();
        return personas;
    }

    

    /*
    
    PARAMETROS: {PARAM}

    ResponseEntity<T>

     200 OK
     404 NOT FOUND
     500 INTERNAL SERVER ERROR

    ENDPOINT, METHOD GET:  http://localhost:7575/personas/{id}

    */
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable int id) {
        Optional<Persona> persona = service.getPerosnaById(id);
        if (persona.isPresent()) {
            // RETORNAR 200 OK
            return ResponseEntity.ok(persona.get());
        } else {
            // RETORNAR 404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }

    /*
     * 
     * 
     * ENDPOINT, METHOD POST: http://localhost:7575/personas/
     * FORMAT JSON: {"nombre":"Juan","telefono":"1234567890"}
     */


    @PostMapping
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona) {
        persona = service.savePersona(persona);
        // Retornar 201 CREATED
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }


    /*
     * 
     * 
     * ENDPOINT, METHOD PUT: http://localhost:7575/personas/{id}
     * FORMAT JSON: {"nombre":"Juan","telefono":"1234567890"}
     */

    @PutMapping("/{id}")
    public ResponseEntity<Persona> modificarPersona(@RequestBody Persona persona, @PathVariable int id) {
        persona.setId(id);
        persona = service.savePersona(persona);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }



    /*
     * 
     * 
     * ENDPOINT, METHOD DELETE: http://localhost:7575/personas/{id}
     */
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable int id) {
        Optional<Persona> persona = service.getPerosnaById(id);
        if (persona.isPresent()) {
            service.deletePersona(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /* 
     
     ENDPOINT, METHOD PATCH: http://localhost:7575/personas/{id}
     FORMAT JSON: {"telefono":"0987654321"}
    */

    @PatchMapping("/{id}")
    public ResponseEntity<Persona> actualizarTelefono(@RequestBody Persona persona, @PathVariable int id) {
        Optional<Persona> personaExistente = service.getPerosnaById(id);
        if (personaExistente.isPresent()) {
            Persona p = personaExistente.get();
            p.setTelefono(persona.getTelefono());
            service.savePersona(p);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
