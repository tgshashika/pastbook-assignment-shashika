package testData;

import java.io.File;
import java.util.Random;

public class PastBookTestData {
    // Create Past Book Test Data
    public String title() {
        Random random = new Random();
        int Low = 0;
        int High = 99;
        int ranNo = random.nextInt(High - Low) + Low;
        String Key = "My Past Book" + ranNo;
        return Key;
    }

    // Upload Images file Path
    File file = new File(".\\src\\images\\image1.png");
    public String filePath = file.getAbsolutePath();
}
