package com.utn.tp_api.servicios;

import com.utn.tp_api.entidades.BaseEntidad;
import com.utn.tp_api.entidades.Persona;
import com.utn.tp_api.repositorios.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServicioImpl<E extends BaseEntidad, ID extends Serializable> implements BaseServicio<E, ID> {

    protected BaseRepository baseRepository;

    public BaseServicioImpl(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
