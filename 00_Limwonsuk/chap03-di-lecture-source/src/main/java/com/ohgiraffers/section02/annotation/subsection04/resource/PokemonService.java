package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

    private Pokemon pokemon;

    /* @Qualifier 어노테이션을 사용하여 squirtle 빈 객체를 지정한다. */
    @Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public void pokemonAttack() {
        pokemon.attack();
    }
}
