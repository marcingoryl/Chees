package pl.edu.pwsztar.chess.service;

import pl.edu.pwsztar.chess.domain.Point;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

public interface ChessService {

    boolean isCorrectMove(FigureMoveDto figureMoveDto);
    Point convert(String point);
}
