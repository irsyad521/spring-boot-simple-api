package com.mahasiswa.mahasiswa.controller;

import com.mahasiswa.mahasiswa.model.Mahasiswa; // Menggunakan nama entitas yang diperbarui
import com.mahasiswa.mahasiswa.service.MahasiswaService; // Menggunakan nama service yang diperbarui
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService; // Menggunakan nama service yang diperbarui

    @GetMapping("/getAll")
    public List<Mahasiswa> list(){
        return mahasiswaService.listAll(); // Menggunakan service yang diperbarui
    }

    @PostMapping("/add")
    public String add(@RequestBody Mahasiswa mahasiswa){ // Menggunakan entitas yang diperbarui
        mahasiswaService.save(mahasiswa); // Menggunakan service yang diperbarui
        return "New Mahasiswa Added"; // Pesan yang diperbarui
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mahasiswa> get(@PathVariable Long id) {
        try {
            Mahasiswa mahasiswa = mahasiswaService.get(id); // Menggunakan service yang diperbarui
            return new ResponseEntity<Mahasiswa>(mahasiswa, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Mahasiswa>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mahasiswa> update(@RequestBody Mahasiswa mahasiswa, @PathVariable Long id){
        try {
            Mahasiswa existingMahasiswa = mahasiswaService.get(id); // Menggunakan service yang diperbarui
            if (existingMahasiswa != null) {
                existingMahasiswa.setNama(mahasiswa.getNama());
                existingMahasiswa.setEmail(mahasiswa.getEmail());
                existingMahasiswa.setTgllahir(mahasiswa.getTgllahir());

                mahasiswaService.save(existingMahasiswa); // Simpan entitas yang telah diubah
                return new ResponseEntity<>(existingMahasiswa, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        mahasiswaService.delete(id); // Menggunakan service yang diperbarui
        return "Deleted Mahasiswa with id " + id; // Pesan yang diperbarui
    }
}
