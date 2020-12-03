package br.edu.usj.ads.lpii.steam;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface devsResopitory extends CrudRepository<Devs, Long>{
    List<Devs> findAll();   
}
