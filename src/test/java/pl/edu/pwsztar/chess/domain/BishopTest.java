package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopTest {

    private final RulesOfGame bishop = new RulesOfGame.Bishop();

    @Tag("Bishop")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  20,  20",
            "-1, -1, -21, -21",
            "-1,  4, -3,   2 ",
            " 0,  1,  2,  -1 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(bishop.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,   -2",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(bishop.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
