package org.ho.section02.annotation.subsection03.collection;

import org.ho.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService   {

  private List<Pokemon> pokemons;

  @Autowired  // Pokemon타입의 Bean들을 모두 가져와서 List에 넣음
  public PokemonService(List<Pokemon>pokemons){
    this.pokemons=pokemons;
  }

  public void pokemonAttack(){
    pokemons.forEach(Pokemon::attack);
  }
}
