package pl.edu.pwsztar.chess.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChessConfiguration {

    @Bean
    ChessFacade filmFacade() {
        return new ChessFacade();
    }
}
