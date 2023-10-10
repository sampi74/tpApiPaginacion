package com.utn.tp_api.repositorios;

import com.utn.tp_api.entidades.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
}
