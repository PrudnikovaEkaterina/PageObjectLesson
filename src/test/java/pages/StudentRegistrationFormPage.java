package pages;

import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {

    public StudentRegistrationFormPage openPage (){
        open ("/automation-practice-form");
        return this;
    }
}
