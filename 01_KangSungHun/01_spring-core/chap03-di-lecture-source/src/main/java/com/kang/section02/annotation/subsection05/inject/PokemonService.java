package com.kang.section02.annotation.subsection05.inject;

import com.kang.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
    public class PokemonService {

        /* pikachu 이름의 빈 지정 */
        @Inject
        @Resource(name = "squirtle")
        private Pokemon pokemon;

        public void pokemonAttack() {
            pokemon.attack();
        }
    }
