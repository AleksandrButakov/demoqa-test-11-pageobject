import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class firstTestPageObject {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = ("0x0");
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @Test
    void successPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setLastName("Petrov")
                .setUserEmail("ivan@bk.ru")
                .setEnterWrapper()
                .setUserNumber("4955552244")
                .setBirthDate("1990", "6", "16")
                .setSubjects("En")
                .setHobbies("Reading")
                .downloadPicture("img.png")
                .currentAddress("Russia")
                .selectionState("NCR")
                .selectionCity("Noida")
                .submtButtonClick();

        // checking the correctness of the entered value
        String[] myDataArray = {"Ivan", "Petrov", "ivan@bk.ru", "Other", "4955552244",
                "16 July,1990", "En", "Reading", "img.png", "Russia",
                "NCR", "Noida"};
        for (int index = 0; index < myDataArray.length; index++) {
            registrationPage.checkForm(myDataArray[index]);
            System.out.println("Checking the value: " + myDataArray[index]);
        }
    }

}
