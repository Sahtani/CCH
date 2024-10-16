package com.youcode.repositories;

import java.util.List;

public interface IGenericRepository<T, ID> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
}
