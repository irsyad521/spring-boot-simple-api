package com.kuliah.kuliah.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kuliah.kuliah.exception.ResourceNotFoundException;
import com.kuliah.kuliah.model.Mahasiswa;
import com.kuliah.kuliah.repository.MahasiswaRepository;

import java.util.List;

@Service
public class MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    @Autowired
    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getMahasiswaById(Long id) {
        return mahasiswaRepository.findById(id).orElse(null);
    }

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaRepository.save(mahasiswa);
    }

    public void deleteMahasiswa(Long id) {
        mahasiswaRepository.deleteById(id);
    }

    public Mahasiswa updateMahasiswa(Long id, Mahasiswa updatedMahasiswa) {
        Mahasiswa existingMahasiswa = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mahasiswa not found with id: " + id));

        existingMahasiswa.setNama(updatedMahasiswa.getNama());
        existingMahasiswa.setEmail(updatedMahasiswa.getEmail());
        existingMahasiswa.setTgllahir(updatedMahasiswa.getTgllahir());

        return mahasiswaRepository.save(existingMahasiswa);
    }
}
