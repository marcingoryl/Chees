package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

@Transactional
public class ChessFacade {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    // ...

    public ChessFacade() {
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        // ...
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {

        // refaktoryzacja?
        switch (figureMoveDto.getType()) {
            case BISHOP:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return bishop.isCorrectMove(new Point(0, 0), new Point(1, 1));
            case KNIGHT:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return knight.isCorrectMove(new Point(0, 0), new Point(1, 1));
        }

        return false;
    }
}
