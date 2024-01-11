package com.kuliah.kuliah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kuliah.kuliah.exception.ResourceNotFoundException;
import com.kuliah.kuliah.model.Nilai;
import com.kuliah.kuliah.repository.NilaiRepository;

import java.util.List;

@Service
public class NilaiService {

    private final NilaiRepository nilaiRepository;

    @Autowired
    public NilaiService(NilaiRepository nilaiRepository) {
        this.nilaiRepository = nilaiRepository;
    }

    public List<Nilai> getAllNilai() {
        return nilaiRepository.findAll();
    }

    public Nilai getNilaiById(Long id) {
        return nilaiRepository.findById(id).orElse(null);
    }

    public Nilai saveNilai(Nilai nilai) {
        return nilaiRepository.save(nilai);
    }

    public void deleteNilai(Long id) {
        nilaiRepository.deleteById(id);
    }

    public Nilai updateNilai(Long id, Nilai updatedNilai) {
        Nilai existingNilai = nilaiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nilai not found with id: " + id));

        existingNilai.setMahasiswa(updatedNilai.getMahasiswa());
        existingNilai.setMatakuliah(updatedNilai.getMatakuliah());
        existingNilai.setNilai(updatedNilai.getNilai());

        return nilaiRepository.save(existingNilai);
    }

}
