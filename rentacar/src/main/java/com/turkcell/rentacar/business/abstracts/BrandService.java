package com.turkcell.rentacar.business.abstracts;

import java.util.List;


import com.turkcell.rentacar.entities.concretes.Brand;

public interface BrandService {

	Brand add(Brand brand);
	Brand update(int id, Brand updatedBrand);
	void delete(int id);
	List<Brand> getAll();
	Brand getById(int id);
}
