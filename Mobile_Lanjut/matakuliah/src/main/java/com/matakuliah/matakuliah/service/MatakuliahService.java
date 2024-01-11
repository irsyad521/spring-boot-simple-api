/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matakuliah.matakuliah.service;

import com.matakuliah.matakuliah.entity.Matakuliah;
import com.matakuliah.matakuliah.repository.MatakuliahRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MatakuliahService {
    private final MatakuliahRepository matakuliahRepository;
    
    @Autowired
    public MatakuliahService (MatakuliahRepository matakuliahRepository) {
        this.matakuliahRepository = matakuliahRepository;
    }
    
    public List <Matakuliah> getAllMatakuliah() {
        return matakuliahRepository.findAll();
    }
    
    public void insertMatakuliah (Matakuliah matakuliah) {
        Optional <Matakuliah> matakuliahOptional = matakuliahRepository.findMatakuliahByNama(matakuliah.getNama());
        if(matakuliahOptional.isPresent()) {
            throw new IllegalStateException("Nama sudah ada");
        }
        matakuliahRepository.save(matakuliah);
    }
}
