package test.youtrack.Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class ScreenshotExtension implements TestWatcher {

    private final Supplier<WebDriver> driverSupplier;

    public ScreenshotExtension(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        WebDriver driver = driverSupplier.get();

        if (driver == null) {
            return;
        }

        try {
            Path screenshotDirectory =
                    Paths.get("target", "screenshots");

            Files.createDirectories(screenshotDirectory);

            String testName = context.getDisplayName()
                    .replaceAll("[^a-zA-Z0-9-_]", "_");

            Path screenshotPath =
                    screenshotDirectory.resolve(testName + ".png");

            byte[] screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            System.out.println(
                    "Скриншот сохранен: "
                            + screenshotPath.toAbsolutePath()
            );

        } catch (IOException e) {
            System.out.println(
                    "Ошибка сохранения скриншота: "
                            + e.getMessage()
            );
        }
    }
}


