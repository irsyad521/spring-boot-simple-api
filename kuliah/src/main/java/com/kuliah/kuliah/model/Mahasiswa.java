package com.kuliah.kuliah.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String email;
    private LocalDate tgllahir;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(LocalDate tgllahir) {
        this.tgllahir = tgllahir;
    }
}
