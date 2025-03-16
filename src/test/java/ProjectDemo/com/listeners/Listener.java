package ProjectDemo.com.listeners;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;
@Log4j2
public class Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.info("--------------------------");
        log.info("This test was disabled: " + context.getTestMethod()
                + " - with reason: " + reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("--------------------------");
        log.info("This test was successful: " + context.getTestMethod());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.info("--------------------------");
        log.info("This test was aborted: " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.info("--------------------------");
        log.info("This test was failed: " + cause.getMessage());
    }
}
