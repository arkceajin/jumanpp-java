package arc.jumanpp;

import java.io.IOException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class JumanController {

    private Juman juman;
    
    JumanController() {
        try {
            this.juman = new Juman();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/parse")
    @ResponseBody
    public String parse(String parseText) {
        String result = null;
        try {
            result = juman.parseString(parseText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
