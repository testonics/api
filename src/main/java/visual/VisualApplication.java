//https://spring.io/guides/tutorials/rest

package visual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VisualApplication extends SpringBootServletInitializer{

    public static void main(String... args) {
        SpringApplication.run(VisualApplication.class, args);
    }

}