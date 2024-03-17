package com.turkcell.rentacar.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class FuelManager implements FuelService{

	  private FuelRepository fuelRepository;

	    @Override
	    public Fuel add(Fuel fuel) {
	        return fuelRepository.save(fuel);
	    }

	    @Override
	    public Fuel update(int id, Fuel updatedFuel) {
	        Optional<Fuel> existingFuelOptional = fuelRepository.findById(id);
	        if (existingFuelOptional.isEmpty()) {
	            throw new IllegalArgumentException("Yakıt Türü Bulunamadı!: " + id);
	        }
	        Fuel existingFuel = existingFuelOptional.get();
	        existingFuel.setName(updatedFuel.getName());
	        return fuelRepository.save(existingFuel);
	    }

	    @Override
	    public void delete(int id) {
	        fuelRepository.deleteById(id);
	    }

	    @Override
	    public List<Fuel> getAll() {
	        return fuelRepository.findAll();
	    }

	    @Override
	    public Fuel getById(int id) {
	        return fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Yakıt Türü bulunamadı: " + id));
	    }
}
