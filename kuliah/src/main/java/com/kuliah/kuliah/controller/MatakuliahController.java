package com.kuliah.kuliah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kuliah.kuliah.model.Matakuliah;
import com.kuliah.kuliah.service.MatakuliahService;

import java.util.List;

@RestController
@RequestMapping("/api/matakuliah")
public class MatakuliahController {
    @Autowired
    private MatakuliahService matakuliahService;

    @GetMapping
    public List<Matakuliah> getAllMatakuliah() {
        return matakuliahService.getAllMatakuliah();
    }

    @GetMapping("/{id}")
    public Matakuliah getMatakuliahById(@PathVariable Long id) {
        return matakuliahService.getMatakuliahById(id);
    }

    @PostMapping
    public Matakuliah saveMatakuliah(@RequestBody Matakuliah matakuliah) {
        return matakuliahService.saveMatakuliah(matakuliah);
    }

    @PutMapping("/{id}")
    public Matakuliah updateMatakuliah(@PathVariable Long id, @RequestBody Matakuliah updatedMatakuliah) {
        return matakuliahService.updateMatakuliah(id, updatedMatakuliah);
    }

    @DeleteMapping("/{id}")
    public void deleteMatakuliah(@PathVariable Long id) {
        matakuliahService.deleteMatakuliah(id);
    }
}
