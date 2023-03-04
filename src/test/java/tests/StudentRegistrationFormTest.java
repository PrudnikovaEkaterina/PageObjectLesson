package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {
    @Test
    public void registrationFormTest() {
        StudentRegistrationFormPage registrationFormPage=new StudentRegistrationFormPage();
        String fName = "Прудникова";
        String lName = "Екатерина";
        String email = "rvsn0913@mail.ru";
        String phoneNumber = "9281960486";
        String currentAddress = "Ростов-на-Дону";
        File file = new File("src/test/resources/ljv.png");

        registrationFormPage.openPage();





        executeJavaScript("$('#fixedban').remove()");  //убираем баннеры java скриптом
        executeJavaScript("$('footer').remove()");

        $ ("#firstName").setValue(fName);
        $ ("#lastName").setValue(lName);
        $ ("#userEmail").setValue(email);
        $x ("//label[text()='Male']").click();
        $x ("//input[@id='userNumber']").setValue(phoneNumber);
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__month-select']//child::option[2]").click();
        $x("//select[@class='react-datepicker__year-select']//child::option[90]").click();
        $x("//div[@aria-label='Choose Wednesday, February 15th, 1989']").click();
        $x("//input[@aria-autocomplete='list']").setValue("e");
        $x("//div[text()='English']").click();
        $x("//label[text()='Reading']").click();
        $x("//input[@id='uploadPicture']").uploadFile(file);
        $x("//textarea[@placeholder='Current Address']").setValue(currentAddress);
        $x("//div[text()='Select State']").click();
        $x("//div[text()='NCR']").click();
        $x("//div[text()='Select City']").click();
        $x("//div[text()='Delhi']").click();
        $x("//button[@id='submit']").click();

        $x("//div[text()='Thanks for submitting the form']")
                .shouldHave(Condition.text("Thanks for submitting the form"));

        $x("//tbody").shouldHave(Condition.text(fName));
        $x("//tbody").shouldHave(Condition.text(lName));
        $x("//tbody").shouldHave(Condition.text(email));
        $x("//tbody").shouldHave(Condition.text("Male"));
        $x("//tbody").shouldHave(Condition.text("15 February,1989"));
        $x("//tbody").shouldHave(Condition.text("Reading"));
        $x("//tbody").shouldHave(Condition.text("ljv.png"));
        $x("//tbody").shouldHave(Condition.text(currentAddress));
        $x("//tbody").shouldHave(Condition.text("NCR Delhi"));
        $x("//tbody").shouldHave(Condition.text(phoneNumber));
        $x("//tbody").shouldHave(Condition.text("English"));




    }
}
