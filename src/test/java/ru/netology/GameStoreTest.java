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

        store.addPlayTime("Test", 5);
        store.addPlayTime("Test1", 4);

        int actual = store.getSumPlayedTime();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    public void Test() {
        GameStore store = new GameStore();

        int actual = 9;
        int expected = 9;

        assertEquals(expected, actual);

    }

}
