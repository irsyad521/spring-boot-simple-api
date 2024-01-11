/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.razif.mahasiswa.controller;

import com.razif.mahasiswa.service.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.razif.mahasiswa.entity.Mahasiswa;


/**
 *
 * @author ACER
 */

@RestController
@RequestMapping("api/v1/mahasiswa")

public class MahasiswaController {
    private final MahasiswaService mahasiswaService;
    
    @Autowired
    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }
    
    @GetMapping
    public List <Mahasiswa> getAllMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }
     @PostMapping
    public void insertMahasiswa (@RequestBody Mahasiswa mahasiswa) {
        mahasiswaService.insertMahasiswa(mahasiswa);
    }


}
