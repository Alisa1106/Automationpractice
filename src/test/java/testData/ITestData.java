package testData;

import org.testng.annotations.DataProvider;
import utils.PropertyReader;

import java.util.Random;

public interface ITestData {

    @DataProvider(name = "Invalid sign in credentials")
    static Object[][] inputForCalculator() {
        return new Object[][]{
                {"", System.getenv().getOrDefault("password", PropertyReader.getProperty("password")), "There is 1 error\nAn email address required."},
                {System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), "", "There is 1 error\nPassword is required."},
                {"", "", "There is 1 error\nAn email address required."}
        };
    }

    default String Random() {
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