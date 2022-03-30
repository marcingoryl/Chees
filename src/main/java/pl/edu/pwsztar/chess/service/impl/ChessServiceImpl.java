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
    private RulesOfGame king;
    private RulesOfGame queen;
    private RulesOfGame rook;
    private RulesOfGame pawn;

    // ...

    public ChessServiceImpl() {
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        king = new RulesOfGame.King();
        queen = new RulesOfGame.Queen();
        rook = new RulesOfGame.Rook();
        pawn = new RulesOfGame.Pawn();
        // ...
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        Point from = convert(figureMoveDto.getSource());
        Point to = convert(figureMoveDto.getDestination());
        // refaktoryzacja?
        switch (figureMoveDto.getType()) {
            case BISHOP:
                return bishop.isCorrectMove(from, to);
            case KNIGHT:
                return knight.isCorrectMove(from, to);
            case KING:
                return king.isCorrectMove(from, to);
            case QUEEN:
                return queen.isCorrectMove(from, to);
            case ROOK:
                return rook.isCorrectMove(from, to);
            case PAWN:
                return pawn.isCorrectMove(from, to);
        }

        return false;
    }

    public Point convert(String point) {
        int x = point.charAt(0) - 'a' + 1;
        int y = Character.getNumericValue(point.charAt(2));
        return new Point(x, y);
    }
}
