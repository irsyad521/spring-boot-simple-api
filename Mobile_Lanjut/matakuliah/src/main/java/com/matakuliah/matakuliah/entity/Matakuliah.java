/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matakuliah.matakuliah.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ACER
 */

@Entity
@Table

public class Matakuliah {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        private String kode;
        private String nama;
        private Integer sks;
    
    public Matakuliah() {
    }
    
    public Matakuliah(Long id, String kode, String nama, Integer sks) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getNama() {
        return nama;
    }
    
    public Integer getSks() {
        return sks;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setSks(Integer sks) {
        this.sks = sks;
    }
    
    @Override
    public String toString() {
        return "Matakuliah{" + "id=" + id + ", kode=" + kode + ", nama=" + nama + ", sks=" + sks + '}';
    }

}
