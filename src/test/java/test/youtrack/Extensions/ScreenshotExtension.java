package test.youtrack.Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotExtension implements TestWatcher {

    private final WebDriver driver;

    public ScreenshotExtension(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testFailed (ExtensionContext context, Throwable cause){
        if (driver == null) {
            return;
        }
    try {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Path directory = Path.of("screenshots");
        Files.createDirectories(directory);

        String testName = context.getDisplayName().replaceAll("[^a-zA-Z0-9-_]", "_");

        Path file = directory.resolve(testName + ".png");

        Files.write(file, screenshot);

        System.out.println("Скриншот сохранен");

    } catch (IOException e) {
            System.out.println("Ошибка сохранения скриншота: " + e.getMessage());

        }
    }
}


