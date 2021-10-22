package com.grupo3.historiasapi.entity.validators;

import com.grupo3.historiasapi.entity.Estudiante;

public class EstudianteValidator {

	public static void save(Estudiante estudiante) {
		
		if (estudiante.getNombres() == null || estudiante.getNombres().trim().isEmpty()) {
			throw new RuntimeException("Los nombres son requeridos");
		}
		
		if (estudiante.getNombres().length() > 50) {
			throw new RuntimeException("El nombre del estudiante es muy largo máximo 50 caracteres");
		}
		
		if (estudiante.getApellidos() == null || estudiante.getApellidos().trim().isEmpty()) {
			throw new RuntimeException("Los apellidos son requeridos");
		}
		
		if (estudiante.getApellidos().length() > 50) {
			throw new RuntimeException("El apellido del estudiante es muy largo máximo 50 caracteres");
		}		
		
		if (estudiante.getGrado() == null || estudiante.getGrado().trim().isEmpty()) {
			throw new RuntimeException("El grado es requerido");
		}
		
		if (estudiante.getGrado().length() > 20) {
			throw new RuntimeException("El grado es muy largo máximo 20 caracteres");
		}
		
		if (estudiante.getEmail() == null || estudiante.getEmail().trim().isEmpty()) {
			throw new RuntimeException("El e-mail es requerido");
		}
		
		if (estudiante.getEmail().length() > 100) {
			throw new RuntimeException("El e-mail es muy largo máximo 100 caracteres");
		}
		
		if (estudiante.getCelular() == null || estudiante.getCelular() == 0) {
			throw new RuntimeException("El celular es requerido");
		}
		
		if (estudiante.getCelular().toString().trim().length() != 10) {
			throw new RuntimeException("El celular debe tener 10 digitos");
		}		
		
		if (estudiante.getEdad() == 0) {
			throw new RuntimeException("La edad es requerida");
		}
		
		if (estudiante.getEdad() < 0 || estudiante.getEdad() > 100) {
			throw new RuntimeException("La edad no es valida, debe estar entre 1 y 100 años");
		}
		
		if (estudiante.getDireccion() == null || estudiante.getDireccion().trim().isEmpty()) {
			throw new RuntimeException("La dirección es requerida");
		}
		
		if (estudiante.getDireccion().length() > 200) {
			throw new RuntimeException("La dirección es muy larga máximo 200 caracteres");
		}		
		
	}
	
}
