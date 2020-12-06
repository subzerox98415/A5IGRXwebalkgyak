package com.beadando.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.beadando.model.Prod;

public interface ProdService {
	List<Prod> getAllProd();
	void saveProd(Prod prod);
	Prod getProdById(long id);
	void deleteProdById(long id);

	Page<Prod> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
