package pl.edu.pwsztar.chess.domain;

public interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * source na destination w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(Point source, Point destination);

    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if(source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            }

            return Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY());
        }
    }

    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if((destination.getY() == source.getY()+1 && source.getX() == destination.getX())
                    || (destination.getY() == source.getY()-1) && source.getX() == destination.getX()
                    || (destination.getY() == source.getY()) && source.getX()+1 == destination.getX()
                    || (destination.getY() == source.getY()) && source.getX()-1 == destination.getX()){
                return false;
            } else if (Math.abs(source.getX() - destination.getX()) ==
                    Math.abs(source.getY() - destination.getY())-1) {
                return true;
            } else return Math.abs(source.getX() - destination.getX()) ==
                    Math.abs(source.getY() - destination.getY() + 1);
        }
    }

    class King implements RulesOfGame {
        @Override
        public boolean isCorrectMove(Point source, Point destination){
            return Math.abs(source.getX() - destination.getX()) == 1 ||
                    Math.abs(source.getY() - destination.getY()) == 1;
        }
    }

    class Queen implements RulesOfGame {
        @Override

        public boolean isCorrectMove(Point source, Point destination){
            if(source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            }
            return true;
        }
    }

    class Rook implements RulesOfGame {
        @Override
        public boolean isCorrectMove(Point source, Point destination){
            return source.getX() == destination.getX() ||
                    source.getY() == destination.getY();
        }
    }

    class Pawn implements RulesOfGame {
        @Override
        public boolean isCorrectMove(Point source, Point destination){
            if(destination.getY() < source.getY()){
                return false;
            } else if (source.getY() > 2 && destination.getY() == source.getY()+1){
                return true;
            } else if (source.getY() == 2 && destination.getY() == 3 || destination.getY() == 4){
                return true;
            }
            return false;
        }
    }

}
