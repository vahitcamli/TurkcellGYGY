package com.turkcell.rentacar.business.abstracts;
import java.util.List;

import com.turkcell.rentacar.entities.concretes.Fuel;
public interface FuelService {
	Fuel add(Fuel fuel);
	void delete(int id);
	List<Fuel> getAll();
	Fuel getById(int id);
	Fuel update(int id, Fuel updatedFuel);
}
