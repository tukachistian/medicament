package com.ecolepratique.medicament2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecolepratique.medicament2.entite.Medicament;
import com.ecolepratique.medicament2.service.MedicamentServiceItf;

@RestController
@RequestMapping("/medicament")
@CrossOrigin("*")
public class MedicamentRestApi {
	@Autowired
	private MedicamentServiceItf medicamentService;
	
	@GetMapping("")
	public List<Medicament> list() {
		System.out.println("InvoiceControllerWeb - displayHome");
		List<Medicament> medicaments = medicamentService.list();
		System.out.println("medicaments=" + medicaments);
		return medicaments;
	}
	@GetMapping("/{id}")
	public Medicament get(@PathVariable("id") Long numDepotLegal) {
		System.out.println("MedicamentRestApi - get(id) ");
		return medicamentService.getByNumDepotLegal(numDepotLegal);
	}
	@PostMapping("")
	public Medicament create(@RequestBody Medicament medicament) {
        return medicamentService.create(medicament);
	}
	@PutMapping("/{id}")
	public Medicament update(@PathVariable("id") Long numDepotLegal, @RequestBody Medicament medicament) {
		return medicamentService.updateByNumDepotLegal(numDepotLegal, medicament);
	}
	@DeleteMapping("/{id}")
	public Medicament delete(@PathVariable("id") Long numDepotLegal) {
		return medicamentService.deleteByNumDepotLegal(numDepotLegal);
	}
	
	
}
