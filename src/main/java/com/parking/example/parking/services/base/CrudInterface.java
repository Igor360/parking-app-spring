package com.parking.example.parking.services.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CrudInterface<T extends JpaRepository> {

    public Set<T> all();

    public void save();
}
