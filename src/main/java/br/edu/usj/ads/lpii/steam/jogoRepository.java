package br.edu.usj.ads.lpii.steam;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface jogoRepository extends CrudRepository <Jogo, Long>{
    List<Jogo> findAll();
}
