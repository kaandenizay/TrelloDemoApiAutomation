package ProjectDemo.com.junitTests;

import ProjectDemo.com.listeners.Listener;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Listener.class)
@Log4j2
public class BaseTests {


    @BeforeAll
    public void setup() {
        log.info("-----Tests are starting-----");
    }

    @BeforeEach
    public void callDriver(){
        log.info("-----Test is started-----");
    }

    @AfterEach
    public void tearDown(){log.info("-----Test is completed-----");}

    @AfterAll
    public static void terminateTest(){
        log.info("-----Tests are completed-----");
    }
}
