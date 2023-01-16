package AlinaTinca.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void takeScreenshot(ChromeDriver driver, String fileName) {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + String.format("/Logs/%s.png", fileName);
        try {
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            System.out.println("The screenshot could not be done");
            e.printStackTrace();
        }
    }

}
