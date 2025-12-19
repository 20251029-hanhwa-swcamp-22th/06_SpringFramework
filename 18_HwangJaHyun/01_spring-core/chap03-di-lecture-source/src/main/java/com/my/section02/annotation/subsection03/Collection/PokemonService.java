package com.my.section02.annotation.subsection03.Collection;

import com.my.section02.annotation.common.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService{
  private List<Pokemon> pokemons;

  public PokemonService(List<Pokemon> pokemons){
    this.pokemons = pokemons;
  }

  public void pokemonAttack(){
    pokemons.forEach(Pokemon::attack);
  }
}
