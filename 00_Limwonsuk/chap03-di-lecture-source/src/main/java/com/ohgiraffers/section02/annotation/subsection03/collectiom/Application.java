package com.ohgiraffers.section02.annotation.subsection03.collectiom;

import com.ohgiraffers.section02.annotation.subsection01.primary.PokemonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application    {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonService pokemonService
                = context.getBean("pokemonServiceCollection",PokemonService.class);

        pokemonService.pokemonAttack();

    }
}
