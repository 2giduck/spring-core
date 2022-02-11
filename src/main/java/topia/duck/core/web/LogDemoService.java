package topia.duck.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import topia.duck.core.common.MyLogger;

@Component
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = "+id);
    }
}
