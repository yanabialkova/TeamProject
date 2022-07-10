package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldNotAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame(null, null);
        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldAddPlayTime() {
        GameStore store = new GameStore();

        int expected = 5;
        int actual = store.addPlayTime("Petya", 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerWithTheSameName() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 5);
        store.addPlayTime("Kolya", 9);
        store.addPlayTime("Petya", 5);

        String actual = store.getMostPlayer();
        String expected = "Petya";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNotMostPlayerWithNullValue() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 0);
        store.addPlayTime("Kolya", 0);

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNotMostPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 4);
        store.addPlayTime("Kolya", 10);

        String expected = "Kolya";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayed() {
        GameStore store = new GameStore();

        store.addPlayTime("Petya", 5);
        store.addPlayTime("Kolya", 4);

        int actual = store.getSumPlayedTime();
        int expected = 9;

        assertEquals(expected, actual);
    }

    //Game
    @Test
    public void shouldTestGameTitle() {
        GameStore store = new GameStore();

        Game game1 = new Game("Нетология Баттл Онлайн", "Аркады", store);
        Game game2 = new Game("Нетология Баттл Онлайн", "Аркады", store);
        Game game3 = new Game("World of Tanks", "Аркады", store);

        assertEquals(true, game1.equals(game2));
        assertEquals(false, game1.equals(game3));
    }

    @Test
    public void shouldTestGameGenre() {
        GameStore store = new GameStore();

        Game game1 = new Game("World of Tanks", "Аркады", store);
        Game game2 = new Game("World of Tanks", "Аркады", store);
        Game game3 = new Game("Tetris", "Головоломки", store);

        assertEquals(true, game1.equals(game2));
        assertEquals(false, game1.equals(game3));
    }

    @Test
    public void shouldTestGameStore() {
        GameStore store1 = new GameStore();
        GameStore store2 = new GameStore();

        Game game1 = new Game("Нетология Баттл Онлайн", "Аркады", store1);
        Game game2 = new Game("Нетология Баттл Онлайн", "Аркады", store1);
        Game game3 = new Game("Double Dragon", "Аркады", store2);

        assertEquals(true, game1.equals(game2));
        assertEquals(false, game1.equals(game3));
    }

    @Test
    public void shouldClassTypeNotEqual() {
        GameStore store = new GameStore();

        Game game1 = new Game("Нетология Баттл Онлайн", "Аркады", store);
        String string = "";

        boolean actual = game1.equals(string);

        assertEquals(false, actual);
    }

}
