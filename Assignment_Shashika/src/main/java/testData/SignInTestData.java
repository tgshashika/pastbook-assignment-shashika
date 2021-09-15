package testData;

import java.util.Random;

public class SignInTestData {

    // Create User Email
    public String CreateUser() {
        Random random = new Random();
        int Low = 0;
        int High = 999;
        int ranNo = random.nextInt(High - Low) + Low;
        String email = "tgshashikaqa" + ranNo + "@gmail.com";
        return email;
    }

    // Change Password
    public String newPassword = "Shashika@1234";

}
