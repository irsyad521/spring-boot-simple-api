package com.hutang.hutang.service;

import com.hutang.hutang.model.Hutang;
import com.hutang.hutang.repository.HutangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HutangService {

    @Autowired
    private HutangRepository hutangRepository;

    public List<Hutang> listAll() {
        return hutangRepository.findAll();
    }

    public void save(Hutang hutang) {

        double hutangbulanan = (hutang.getJumlah() * hutang.getBunga() / 100) / 12;


        double total = hutang.getJumlah() + hutangbulanan * hutang.getLama();
        hutang.setBunga(12.00);

        hutang.setTotal(total);
        hutangRepository.save(hutang);
    }

    public Hutang get(Integer id) {
        return hutangRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        hutangRepository.deleteById(id);
    }
}
