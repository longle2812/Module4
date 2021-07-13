package com.codegym.module4exam.service.country;

import com.codegym.module4exam.model.Country;
import com.codegym.module4exam.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Optional<Country> findbyId(Long id) {
        return countryRepository.findById(id);
    }
}
