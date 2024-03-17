package com.turkcell.rentacar.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ModelManager implements ModelService{

    private ModelRepository modelRepository;

    @Override
    public Model add(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(int id, Model updatedModel) {
        Optional<Model> existingModelOptional = modelRepository.findById(id);
        if (existingModelOptional.isEmpty()) {
            throw new IllegalArgumentException("Model Bulunamadı!: " + id);
        }
        Model existingModel = existingModelOptional.get();
        existingModel.setName(updatedModel.getName());
        return modelRepository.save(existingModel);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model bulunamadı: " + id));
    }
}
