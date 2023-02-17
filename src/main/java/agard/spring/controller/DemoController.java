package agard.spring.controller;

import agard.spring.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // Fields //
    private final DemoService demoService;

    // Constructors //
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    // Request methods //

    //http://loclhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    //http://localhost:8080/todo-list/welcome?user=Ram&age=24
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("greeting", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("Model= {}", model);
        //prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    // Model Attributes //
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();

    }
}
