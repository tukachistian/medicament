package com.ecolepratique.medicament2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecolepratique.medicament2.dao.medicament2DaoItf;
import com.ecolepratique.medicament2.entite.Medicament;
import com.ecolepratique.medicament2.repository.MedicamentRepositoryItf;

@Service
public class MedicamentService implements MedicamentServiceItf {
	@Autowired
	private medicament2DaoItf medicamentDao;
	
	@Override
	public List<Medicament> list() {
		return medicamentDao.findAll();
	}
	@Override
	public Medicament create(Medicament medicament) {
		return medicamentDao.save(medicament);
	}
	@Override
	public Medicament getByNumDepotLegal(Long numDepotLegal) {
		return medicamentDao.findById(numDepotLegal).get();
	}
	@Override
	public Medicament deleteByNumDepotLegal(Long numDepotLegal) {
		
		Medicament medicament = getByNumDepotLegal(numDepotLegal);
		medicamentDao.deleteById(numDepotLegal);
		return medicament;
	}
	@Override
	public Medicament updateByNumDepotLegal(Long numDepotLegal, Medicament medicament) {
		medicament.setNumDepotLegal(numDepotLegal);
		return medicamentDao.save(medicament);
	}
	
}
