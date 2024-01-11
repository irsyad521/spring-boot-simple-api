package com.kuliah.kuliah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kuliah.kuliah.model.Mahasiswa;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    // Mungkin bisa ditambahkan metode tambahan sesuai kebutuhan
}
