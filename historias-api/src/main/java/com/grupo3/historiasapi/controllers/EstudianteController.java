package com.grupo3.historiasapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo3.historiasapi.entity.Estudiante;
import com.grupo3.historiasapi.entity.validators.EstudianteValidator;
import com.grupo3.historiasapi.repository.EstudianteRepository;

@RestController
public class EstudianteController {
	
	@Autowired
	private EstudianteRepository estudianteRepo;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/estudiantes/{estudianteId}")
	public ResponseEntity<Estudiante> findById(@PathVariable("estudianteId") Long estudianteId) {
		Estudiante objEstudiante = estudianteRepo.findById(estudianteId)
				.orElseThrow(() -> new RuntimeException("No existe el estudiante"));
		return new ResponseEntity<Estudiante>(objEstudiante, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value="/estudiantes/{estudianteId}")
	public ResponseEntity<Void> delete(@PathVariable("estudianteId") Long estudianteId) {
		Estudiante objEstudiante = estudianteRepo.findById(estudianteId)
				.orElseThrow(() -> new RuntimeException("No existe el estudiante"));

		estudianteRepo.delete(objEstudiante);
		return new ResponseEntity(HttpStatus.OK);
		
	}
		
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/estudiantes")
	public ResponseEntity<List<Estudiante>> findAll(){
		List<Estudiante> estudiantes = estudianteRepo.findAll();
		return new ResponseEntity<List<Estudiante>>(estudiantes, HttpStatus.OK);
				
	}
	
	@CrossOrigin(origins = "*")	
	@PostMapping(value = "/estudiantes")
	public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante){
		EstudianteValidator.save(estudiante);
		Estudiante nuevoEstudiante = estudianteRepo.save(estudiante);
		return new ResponseEntity<Estudiante>(nuevoEstudiante, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "*")	
	@PutMapping(value = "/estudiantes")
	public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante){
		EstudianteValidator.save(estudiante);
		Estudiante existeEstudiante = estudianteRepo.findById(estudiante.getId())
				.orElseThrow(() -> new RuntimeException("No existe el estudiante"));
		
		existeEstudiante.setNombres(estudiante.getNombres());
		existeEstudiante.setApellidos(estudiante.getApellidos());
		existeEstudiante.setGrado(estudiante.getGrado());
		existeEstudiante.setEmail(estudiante.getEmail());
		existeEstudiante.setCelular(estudiante.getCelular());
		existeEstudiante.setEdad(estudiante.getEdad());
		existeEstudiante.setFechanacimiento(estudiante.getFechanacimiento());
		existeEstudiante.setSexo(estudiante.getSexo());
		existeEstudiante.setDireccion(estudiante.getDireccion());
		
		estudianteRepo.save(existeEstudiante);
		return new ResponseEntity<Estudiante>(existeEstudiante, HttpStatus.OK);
		
	}
	
}
