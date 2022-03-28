package pl.edu.pwsztar.chess.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.domain.Point;
import pl.edu.pwsztar.chess.domain.RulesOfGame;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;
import pl.edu.pwsztar.chess.service.ChessService;

@Service
@Transactional
public class ChessServiceImpl implements ChessService {
    private RulesOfGame bishop;
    private RulesOfGame knight;
    // ...

    public ChessServiceImpl() {
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
