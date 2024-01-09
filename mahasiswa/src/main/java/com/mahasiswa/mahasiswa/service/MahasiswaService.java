package com.mahasiswa.mahasiswa.service;

import com.mahasiswa.mahasiswa.model.Mahasiswa;
import com.mahasiswa.mahasiswa.repository.MahasiswaRepository; // Ubah nama repositori sesuai perubahan nama entitas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository; // Ubah nama repositori sesuai perubahan nama entitas

    public List<Mahasiswa> listAll(){
        return mahasiswaRepository.findAll();
    }

    public void save(Mahasiswa mahasiswa){
        mahasiswaRepository.save(mahasiswa);
    }

    public Mahasiswa get(Long id){
        return mahasiswaRepository.findById(id).get();
    }

    public void delete(Long id){
        mahasiswaRepository.deleteById(id);
    }
}
