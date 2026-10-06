package test.youtrack.Extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class ScreenshotExtension implements AfterTestExecutionCallback {

    private final Supplier<WebDriver> driverSupplier;

    public ScreenshotExtension(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {

        if (context.getExecutionException().isEmpty()) {
            return;
        }

        WebDriver driver = driverSupplier.get();

        if (driver == null) {
            return;
        }

        try {
            Path screenshotDirectory =
                    Paths.get("target", "screenshots");

            Files.createDirectories(screenshotDirectory);

            String className =
                    context.getRequiredTestClass().getSimpleName();

            String testName =
                    context.getDisplayName()
                            .replaceAll("[^a-zA-Z0-9-_]", "_");

            String fileName =
                    className + "_" + testName + ".png";

            Path screenshotPath =
                    screenshotDirectory.resolve(fileName);

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


