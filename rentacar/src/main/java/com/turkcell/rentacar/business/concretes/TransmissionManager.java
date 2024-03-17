package com.turkcell.rentacar.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService{

	private TransmissionRepository transmissionRepository;

    @Override
    public Transmission add(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }
    @Override
    public Transmission update(int id, Transmission updatedTransmission) {
        Optional<Transmission> existingTransmissionOptional = transmissionRepository.findById(id);
        if (existingTransmissionOptional.isEmpty()) {
            throw new IllegalArgumentException("Transmission Bulunamadı!: " + id);
        }
        Transmission existingTransmission = existingTransmissionOptional.get();
        existingTransmission.setName(updatedTransmission.getName());
        return transmissionRepository.save(existingTransmission);
    }

    @Override
    public void delete(int id) {
    	Optional<Transmission> existingTransmissionOptional = transmissionRepository.findById(id);
        if (existingTransmissionOptional.isEmpty()) {
            throw new IllegalArgumentException("Transmission Bulunamadı!: " + id);
        }
        transmissionRepository.deleteById(id);
    }

    @Override
    public List<Transmission> getAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        return transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission bulunamadı: " + id));
    }

}
