package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
public class PokemonService {

    /* 1. 필드 주입 */
    @Inject
    @Named("pikachu")
    private Pokemon pokemon;

    public void pokemonAttack() {
        pokemon.attack();

    }
    /* 2. 생성자 주입 */
    @Inject
    public PokemonService(@Named("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
