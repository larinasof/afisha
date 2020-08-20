package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerFilmsNotExistTest {
    private AfishaManager manager = new AfishaManager();

    @Test
    public void shouldShowIfNotExist(){
        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);

    }

}
