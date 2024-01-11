package com.kuliah.kuliah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kuliah.kuliah.model.Matakuliah;

public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long> {
    // Mungkin bisa ditambahkan metode tambahan sesuai kebutuhan
}
