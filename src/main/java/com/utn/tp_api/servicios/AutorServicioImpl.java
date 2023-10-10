package com.utn.tp_api.servicios;

import com.utn.tp_api.entidades.Autor;
import com.utn.tp_api.repositorios.AutorRepository;
import com.utn.tp_api.repositorios.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicioImpl extends BaseServicioImpl<Autor,Long> implements AutorServicio {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServicioImpl(BaseRepository<Autor,Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository=autorRepository;
    }

    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try {

            List<Autor> entities  =    autorRepository.findAll();

            return entities;

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try {
            Optional<Autor> entityOptional   = autorRepository.findById(id);
            return entityOptional.get();

        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try {
            entity = autorRepository.save(entity);
            return entity;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try {
            Optional<Autor> entityOptional  = autorRepository.findById(id);
            Autor autor =entityOptional.get();
            // Si existe la entidad la asigno a la variable persona y luego igual que Save
            autor = autorRepository.save(entity);
            return autor;
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)) {
                autorRepository.deleteById(id);
                return true;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }
}
