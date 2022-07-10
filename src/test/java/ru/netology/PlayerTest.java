package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);


        int expected = 0;

        int expected = 3;

        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void shouldShowMostPlayerByGenre() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Локально", "Стратегия");
        Game game2 = store.publishGame("Нетология Баттл", "Карточная игры");

        Player player = new Player("Petya");

        Game expected = null;
        Game actual = player.mostPlayerByGenre(game.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldHoursOfPlayer() {

        Player player = new Player("Petya");

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        player.sumGenre(game.getGenre());

        int expected = 0;
        int actual = player.play(game,player.sumGenre(game.getGenre()));

        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldNotInstalledGame() {
//
//        Player player = new Player("Petya");
//
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        assertThrows(RuntimeException.class, () -> player.play(game,2));
//    }

    @Test
    public void shouldGetNameOfPlayer() {

        Player player = new Player("Petya");

        String expected = "Petya";
        String actual = player.getName();

        assertEquals(expected, actual);
    }
}

