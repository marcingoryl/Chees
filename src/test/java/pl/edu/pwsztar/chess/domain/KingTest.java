package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {

    private final RulesOfGame king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            "5,  1,  5,  2",
            "5,  2,  4,  2",
            "4,  2,  5,  3",
            "5,  3,  6,  2",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  1,  3,  6",
            "2, 2, 2,  7"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

}
