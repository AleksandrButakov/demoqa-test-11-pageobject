import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class firstTestPageObject {

    RegistrationPage registrationPage = new RegistrationPage();

    String
            firstName = "Ivan",
            lastName = "Petrov",
            userEmail = "ivan@bk.ru",
            gender = "Other",
            userNumber = "4955552244",
            birthDateYear = "1990",
            birthDateMounth = "6",
            birthDateDay = "16",
            birthDataResult = "16 July,1990",
            subjects = "En",
            hobbies = "Reading",
            downloadPicture = "img.png",
            currentAddress = "Russia",
            selectionState = "NCR",
            selectionCity = "Noida";

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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setEnterWrapper(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDateYear, birthDateMounth, birthDateDay)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .downloadPicture(downloadPicture)
                .currentAddress(currentAddress)
                .selectionState(selectionState)
                .selectionCity(selectionCity)
                .submtButtonClick();

        // checking the correctness of the entered value
        String[] myDataArray = {firstName, lastName, userEmail, gender, userNumber,
                birthDataResult, subjects, hobbies, downloadPicture, currentAddress,
                selectionState, selectionCity};
        for (int index = 0; index < myDataArray.length; index++) {
            registrationPage.checkForm(myDataArray[index]);
            System.out.println("Checking the value: " + myDataArray[index]);
        }
    }

}
