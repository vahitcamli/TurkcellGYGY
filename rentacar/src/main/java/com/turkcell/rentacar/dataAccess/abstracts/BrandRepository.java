package com.turkcell.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.rentacar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{

}
