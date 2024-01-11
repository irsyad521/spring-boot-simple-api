package com.kuliah.kuliah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kuliah.kuliah.model.Nilai;

public interface NilaiRepository extends JpaRepository<Nilai, Long> {
    // Mungkin bisa ditambahkan metode tambahan sesuai kebutuhan
}
