package dukes;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DukeRest {

    @Autowired
    private ServletContext context;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Duke from " + context.getContextPath();
    }
}
