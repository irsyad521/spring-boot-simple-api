package com.kuliah.kuliah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kuliah.kuliah.exception.ResourceNotFoundException;
import com.kuliah.kuliah.model.Matakuliah;
import com.kuliah.kuliah.repository.MatakuliahRepository;

import java.util.List;

@Service
public class MatakuliahService {

    private final MatakuliahRepository matakuliahRepository;

    @Autowired
    public MatakuliahService(MatakuliahRepository matakuliahRepository) {
        this.matakuliahRepository = matakuliahRepository;
    }

    public List<Matakuliah> getAllMatakuliah() {
        return matakuliahRepository.findAll();
    }

    public Matakuliah getMatakuliahById(Long id) {
        return matakuliahRepository.findById(id).orElse(null);
    }

    public Matakuliah saveMatakuliah(Matakuliah matakuliah) {
        return matakuliahRepository.save(matakuliah);
    }

    public void deleteMatakuliah(Long id) {
        matakuliahRepository.deleteById(id);
    }

    public Matakuliah updateMatakuliah(Long id, Matakuliah updatedMatakuliah) {
        Matakuliah existingMatakuliah = matakuliahRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matakuliah not found with id: " + id));

        existingMatakuliah.setKode(updatedMatakuliah.getKode());
        existingMatakuliah.setNama(updatedMatakuliah.getNama());
        existingMatakuliah.setSks(updatedMatakuliah.getSks());

        return matakuliahRepository.save(existingMatakuliah);
    }
}
