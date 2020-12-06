package com.beadando.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.beadando.model.Prod;
import com.beadando.repository.ProdRepository;

@Service
public class ProdServiceImpl implements ProdService {

	@Autowired
	private ProdRepository prodRepository;

	@Override
	public List<Prod> getAllProd() {
		return prodRepository.findAll();
	}

	@Override
	public void saveProd(Prod prod) {
		this.prodRepository.save(prod);
	}

	@Override
	public Prod getProdById(long id) {
		Optional<Prod> optional = prodRepository.findById(id);
		Prod prod = null;
		if (optional.isPresent()) {
			prod = optional.get();
		} else {
			throw new RuntimeException(" Termék nincs az adatbázisban :: " + id);
		}
		return prod;
	}

	@Override
	public void deleteProdById(long id) {
		this.prodRepository.deleteById(id);
	}

	@Override
	public Page<Prod> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.prodRepository.findAll(pageable);
	}

	


}
