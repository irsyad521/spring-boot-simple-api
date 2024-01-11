/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matakuliah.matakuliah.controller;

import com.matakuliah.matakuliah.entity.Matakuliah;
import com.matakuliah.matakuliah.service.MatakuliahService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */

@RestController
@RequestMapping("api/v1/matakuliah")

public class MatakuliahController {
    private final MatakuliahService matakuliahService;
    
    @Autowired
    public MatakuliahController(MatakuliahService matakuliahService) {
        this.matakuliahService = matakuliahService;
    }
    
    @GetMapping
    public List <Matakuliah> getAllMatakuliah() {
        return matakuliahService.getAllMatakuliah();
    }
     @PostMapping
    public void insertMatakuliah (@RequestBody Matakuliah matakuliah) {
        matakuliahService.insertMatakuliah(matakuliah);
    }
}
