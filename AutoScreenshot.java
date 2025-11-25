import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class AutoScreenshot {

    // Interval in seconds (20 seconds)
    private static final long INTERVAL_SECONDS = 20;
    private static final String FOLDER_NAME = "screenshots";

    private final Robot robot;
    private final Rectangle screenRect;
    private final File outputDir;
    private final SimpleDateFormat dateFormat;

    public AutoScreenshot() throws AWTException {
        // Robot for capturing the screen
        robot = new Robot();

        // Full screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenRect = new Rectangle(screenSize);

        // Folder where screenshots will be stored (inside current working directory)
        outputDir = new File(FOLDER_NAME);
        if (!outputDir.exists()) {
            boolean created = outputDir.mkdirs();
            if (!created) {
                System.err.println("❌ Could not create screenshots folder at: " + outputDir.getAbsolutePath());
            }
        }

        // File name format: screenshot_20251125_141530.png
        dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    }

    private void takeScreenshot() {
        try {
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            String timestamp = dateFormat.format(new Date());
            File outputFile = new File(outputDir, "screenshot_" + timestamp + ".png");

            ImageIO.write(screenCapture, "png", outputFile);

            System.out.println("✅ Saved screenshot: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }

    public void start() {
        System.out.println("🚀 AutoScreenshot service started.");
        System.out.println("⏱  Interval: " + INTERVAL_SECONDS + " seconds");
        System.out.println("📁 Screenshots folder: " + outputDir.getAbsolutePath());
        System.out.println("🔚 Close the program or stop run to exit.\n");

        while (true) {
            // take one screenshot
            takeScreenshot();

            // wait INTERVAL_SECONDS before next one
            try {
                Thread.sleep(INTERVAL_SECONDS * 1000); // 20 * 1000 ms
            } catch (InterruptedException e) {
                System.err.println("⛔ Screenshot loop interrupted. Exiting.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            AutoScreenshot autoScreenshot = new AutoScreenshot();
            autoScreenshot.start();
        } catch (AWTException e) {
            System.err.println("❌ Cannot initialize screen capture: " + e.getMessage());
        }
    }
}
