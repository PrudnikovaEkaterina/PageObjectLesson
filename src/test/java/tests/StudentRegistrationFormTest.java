package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class StudentRegistrationFormTest extends TestBase {

    StudentRegistrationFormPage registrationFormPage = new StudentRegistrationFormPage();

    @Test
    public void registrationFormTest() {

        File file = new File("src/test/resources/ljv.png");

        String firstName = "Прудникова",
                lastName = "Екатерина",
                email = "rvsn0913@mail.ru",
                gender = "Female",
                phoneNumber = "9281960486",
                dayOfBirth = "15",
                monthOfBirth = "February",
                yearOfBirth = "1989",
                charOAutoComplete = "e",
                subject = "English",
                hobby = "Reading",
                address = "Ростов-на-Дону",
                state = "Haryana",
                city = "Karnal";

        registrationFormPage.openPage()
                .removeTheBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .chooseGender(gender)
                .setPhone(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .chooseSubjects(charOAutoComplete, subject)
                .chooseHobbies(hobby)
                .uploadPicture(file)
                .setCurrentAdress(address)
                .selectState(state)
                .selectCity(city)
                .submitButtonClick();

        registrationFormPage.verifyModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "ljv.png")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);


    }
}
