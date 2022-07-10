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
    public void shouldGetException() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 4);

        assertThrows(RuntimeException.class, () -> player.play(game2, 5));

    }

    @Test
    public void shouldSumGenreWithPlayTime0() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);

        player.play(game, 0);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);

    }

    @Test
    public void shouldInstallGames() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);

        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetExceptionWhenGameNotInstall() {
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> player.play(game, 2));

    }

    @Test
    public void shouldGetMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("рпорполр", "Аркады");
        Game game1 = store.publishGame("Тетрис", "Головоломка");


        Player player = new Player("Petya");

        player.installGame(game);
        player.installGame(game2);
        player.installGame(game1);

        player.play(game, 7);
        player.play(game2, 5);
        player.play(game1, 7);

        String expected = "Нетология Баттл Онлайн";
        String actual = player.mostPlayerByGenre("Аркады");


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

    @Test
    public void shouldGetMostPlayerByGenreIfNotPlay() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("рпорполр", "Аркады");
        Game game1 = store.publishGame("Тетрис", "Головоломка");


        Player player = new Player("Petya");

        player.installGame(game);
        player.installGame(game2);
        player.installGame(game1);

        player.play(game, 0);

        String expected = null;
        String actual = player.mostPlayerByGenre("Стрелялки");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("рпорполр", "Аркады");
        Game game1 = store.publishGame("khujgkjhgkhg", "Аркады");


        Player player = new Player("Petya");

        player.installGame(game);
        player.installGame(game2);
        player.installGame(game1);

        player.play(game, 12);
        player.play(game1, 5);
        player.play(game2, 7);

        int expected = 24;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNameOfPlayer() {

        Player player = new Player("Petya");

        String expected = "Petya";
        String actual = player.getName();

        assertEquals(expected, actual);
    }
}

