package mancala.game;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collections;
import java.util.logging.Logger;


@SpringBootApplication
@EnableScheduling
public class Application {
    static Logger log = Logger.getLogger(Application.class.getName());
    private final Environment env;

    public Application(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "dev"));
        Environment env = app.run(args).getEnvironment();
        log.info("***********************************************************************");

    }
}
