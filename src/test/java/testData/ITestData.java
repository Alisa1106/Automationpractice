package testData;

import org.testng.annotations.DataProvider;
import utils.PropertyReader;

import java.util.Random;

public interface ITestData {

    @DataProvider(name = "Invalid sign in credentials")
    static Object[][] inputForRegistration() {
        return new Object[][]{
                {"", System.getenv().getOrDefault("password", PropertyReader.getProperty("password")), "There is 1 error\nAn email address required."},
                {System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), "", "There is 1 error\nPassword is required."},
                {"", "", "There is 1 error\nAn email address required."}
        };
    }

    @DataProvider(name = "Update address")
    static Object[][] inputForUpdateAddress() {
        return new Object[][]{
                {"314 Robinson Lane", "DE", "Delaware", "19805", "United States", "111000111", "My base address"},
                {"401 Magnetic Drive, Unit 2", "DM", "Iowa", "32104", "United States", "111111111", "My base address"},
                {"5 S.Main Street", "NJ", "New Jersey", "07726", "United States", "123456789", "My base address"}
        };
    }

    default String getRandomChar() {
        Random random = new Random();
        char nextChar;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            nextChar = (char) (random.nextInt(26) + 97);
            stringBuilder.append(nextChar);
        }
        return stringBuilder.toString();
    }
}