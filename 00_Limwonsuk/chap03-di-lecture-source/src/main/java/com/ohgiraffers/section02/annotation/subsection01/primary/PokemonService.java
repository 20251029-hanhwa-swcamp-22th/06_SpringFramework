package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.stereotype.Service;

// 스캔해서 Bean으로 등록해라
@Service("pokemonServicePrimary")
public class PokemonService {

    private final Pokemon pokemon;

    public PokemonService(Pokemon pokemon){
        this.pokemon = pokemon; // 피카츄 1순위
    }

    public void pokemonAttack(){
        pokemon.attack();
    }

}
