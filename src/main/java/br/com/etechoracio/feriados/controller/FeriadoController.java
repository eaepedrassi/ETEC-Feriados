package br.com.etechoracio.feriados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.feriados.dao.FeriadoDAO;
import br.com.etechoracio.feriados.model.Feriado;

@RestController
@RequestMapping("/feriado")
public class FeriadoController {
	

	@Autowired
	private FeriadoDAO dao;
	

	@GetMapping
	public List<Feriado> listar() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Feriado> buscar(@PathVariable String id) {
		Optional<Feriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public void inserir(@RequestBody Feriado f) {
		dao.save(f);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Feriado> delete(@PathVariable String id) {
		Optional<Feriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			dao.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Feriado> update(@PathVariable String id, 
					   @RequestBody Feriado feriado) {
		Optional<Feriado> resultado = dao.findById(id);
		if (resultado.isPresent()) {
			feriado.setId(id);
			dao.save(feriado);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
	