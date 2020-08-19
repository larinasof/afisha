package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTestFilmsNotExist {

    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    @Test
    public void shouldShowIfNotExist(){
        Film[] returned = new Film[]{};
        doReturn(returned).when(repository).findAll();

        Film[] actual = manager.getLast();
        Film[] expected = new Film[]{};

        assertArrayEquals(expected, actual);

    }

}
