package com.kuliah.kuliah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kuliah.kuliah.model.Nilai;
import com.kuliah.kuliah.service.NilaiService;

import java.util.List;

@RestController
@RequestMapping("/api/nilai")
public class NilaiController {
    @Autowired
    private NilaiService nilaiService;

    @GetMapping
    public List<Nilai> getAllNilai() {
        return nilaiService.getAllNilai();
    }

    @GetMapping("/{id}")
    public Nilai getNilaiById(@PathVariable Long id) {
        return nilaiService.getNilaiById(id);
    }

    @PostMapping
    public Nilai saveNilai(@RequestBody Nilai nilai) {
        return nilaiService.saveNilai(nilai);
    }

    @PutMapping("/{id}")
    public Nilai updateNilai(@PathVariable Long id, @RequestBody Nilai updatedNilai) {
        return nilaiService.updateNilai(id, updatedNilai);
    }

    @DeleteMapping("/{id}")
    public void deleteNilai(@PathVariable Long id) {
        nilaiService.deleteNilai(id);
    }
}
