/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.razif.mahasiswa.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.razif.mahasiswa.entity.Mahasiswa;
import java.util.Optional;

/**
 *
 * @author ACER
 */
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

    public Optional<Mahasiswa> findMahasiswaByEmail(String email);

}
