package local.ts3snet.booklibrary_test_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class BookLibraryTestWebApplication {
    private static final Logger logger = Logger.getLogger(BookLibraryTestWebApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryTestWebApplication.class, args);
    }

}
