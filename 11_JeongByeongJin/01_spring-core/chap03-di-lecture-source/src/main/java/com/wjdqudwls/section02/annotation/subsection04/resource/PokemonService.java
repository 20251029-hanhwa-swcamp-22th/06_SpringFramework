package com.wjdqudwls.section02.annotation.subsection04.resource;

import com.wjdqudwls.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

  @Resource
  private List<Pokemon> pokemonList;

  public void pokemonAttack() {
    pokemonList.forEach(Pokemon::attack);
  }
}
