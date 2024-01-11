package com.hutang.hutang.controller;

import com.hutang.hutang.model.Hutang;
import com.hutang.hutang.service.HutangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hutang")
public class HutangController {

    @Autowired
    private HutangService hutangService;

    @GetMapping("/getAll")
    public List<Hutang> list() {
        return hutangService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Hutang hutang) {
        hutangService.save(hutang);
        return "Hutang ditambahkan";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hutang> get(@PathVariable Integer id) {
        try {
            Hutang hutang = hutangService.get(id);
            return new ResponseEntity<>(hutang, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hutang> update(@RequestBody Hutang hutang, @PathVariable Integer id) {
        try {
            Hutang existingHutang = hutangService.get(id);
            if (existingHutang != null) {
                existingHutang.setIdnasabah(hutang.getIdnasabah());
                existingHutang.setJumlah(hutang.getJumlah());
                existingHutang.setLama(hutang.getLama());
                existingHutang.setBunga(hutang.getBunga());
                existingHutang.setTotal(hutang.getTotal());

                hutangService.save(existingHutang);
                return new ResponseEntity<>(existingHutang, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        hutangService.delete(id);
        return "Deleted Hutang  dengan " + id;
    }
}
