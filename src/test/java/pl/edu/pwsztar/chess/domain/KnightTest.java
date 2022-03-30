package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    private final RulesOfGame knight = new RulesOfGame.Knight();

    @Tag("Kinght")
    @ParameterizedTest
    @CsvSource({
            "2,  1,  3,  3",
            "3,  3,  4,  1",
            "4,  1,  2,  4",
            "2,  4,  5,  8",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "3,  1,  3,  2",
            "3, 1, 8,  5"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
