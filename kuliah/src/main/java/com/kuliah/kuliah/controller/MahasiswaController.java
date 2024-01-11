package com.kuliah.kuliah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kuliah.kuliah.model.Mahasiswa;
import com.kuliah.kuliah.service.MahasiswaService;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @GetMapping
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }

    @GetMapping("/{id}")
    public Mahasiswa getMahasiswaById(@PathVariable Long id) {
        return mahasiswaService.getMahasiswaById(id);
    }

    @PostMapping
    public Mahasiswa saveMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.saveMahasiswa(mahasiswa);
    }

    @PutMapping("/{id}")
    public Mahasiswa updateMahasiswa(@PathVariable Long id, @RequestBody Mahasiswa updatedMahasiswa) {
        return mahasiswaService.updateMahasiswa(id, updatedMahasiswa);
    }

    @DeleteMapping("/{id}")
    public void deleteMahasiswa(@PathVariable Long id) {
        mahasiswaService.deleteMahasiswa(id);
    }
}
