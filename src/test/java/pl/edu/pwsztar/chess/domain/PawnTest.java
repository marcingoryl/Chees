package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {

    private final RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            "4,  2,  4,  4",
            "4,  4,  5,  4",
            "5,  4,  4,  5",
            "4,  6,  4,  7",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "7,  7,  7,  6",
            "3, 3, 4,  3"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
