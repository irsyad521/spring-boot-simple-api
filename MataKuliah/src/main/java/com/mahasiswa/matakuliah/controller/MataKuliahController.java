package com.mahasiswa.matakuliah.controller;

import com.mahasiswa.matakuliah.model.MataKuliah;
import com.mahasiswa.matakuliah.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/matakuliah")
public class MataKuliahController {
    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping("/getAll")
    public List<MataKuliah> list(){
        return mataKuliahService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody MataKuliah mataKuliah){
        mataKuliahService.save(mataKuliah);
        return new ResponseEntity<>("New MataKuliah Added", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MataKuliah> get(@PathVariable Long id) {
        try {
            MataKuliah mataKuliah = mataKuliahService.get(id);
            return new ResponseEntity<>(mataKuliah, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MataKuliah> update(@RequestBody MataKuliah mataKuliah, @PathVariable Long id){
        try {
            MataKuliah existingMataKuliah = mataKuliahService.get(id);
            if (existingMataKuliah != null) {
                existingMataKuliah.setNama(mataKuliah.getNama());
                existingMataKuliah.setKode(mataKuliah.getKode());
                existingMataKuliah.setSks(mataKuliah.getSks());

                mataKuliahService.save(existingMataKuliah);
                return new ResponseEntity<>(existingMataKuliah, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        mataKuliahService.delete(id);
        return new ResponseEntity<>("Deleted MataKuliah with id " + id, HttpStatus.OK);
    }
}
