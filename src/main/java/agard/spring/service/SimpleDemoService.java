package agard.spring.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleDemoService implements DemoService {

    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo application!";
    }
}
