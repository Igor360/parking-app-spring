package com.parking.example.parking.services.base;

import com.parking.example.parking.exceptions.models.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CRUDService<T extends JpaRepository, E extends Object> {

    @Autowired
    protected T repository;

    public List<E> all() {
        return this.repository.findAll();
    }

    public E get(Object id) {
        return (E) this.repository.getOne(id);
    }

    public void remove(Long id) {
        E entity = this.get(id);
        this.repository.delete(entity);
    }

    public void save(E entity) {
        this.repository.save(entity);
    }


    public void update(Long id, E entity) {
        E foundEntity = (E)this.repository.findById(id);

    }

}
