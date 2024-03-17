package com.turkcell.rentacar.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	@Override
	public Brand add(Brand brand) {
		Brand createdBrand = brandRepository.save(brand);
		return createdBrand;
	}
	@Override
	public Brand update(int id, Brand updatedBrand) {
		Optional<Brand> existingBrandOptional = brandRepository.findById(id);
        if (existingBrandOptional.isEmpty()) {
            throw new IllegalArgumentException("Marka Bulunamadı!: " + id);
        }
        Brand existingBrand = existingBrandOptional.get();
        existingBrand.setName(updatedBrand.getName());
        return brandRepository.save(existingBrand);
	}
	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
		
	}
	@Override
	public List<Brand> getAll() {
		return brandRepository.findAll();
	}
	@Override
	public Brand getById(int id) {
		return brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Marka bulunamadı: " + id));
	}
}