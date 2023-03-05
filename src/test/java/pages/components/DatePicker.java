package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class DatePicker {
    private SelenideElement
            monthSelect = $x("//select[@class='react-datepicker__month-select']"),
            yearSelect = $x("//select[@class='react-datepicker__year-select']");

    public void setDay(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        $x("//div[@class='react-datepicker__month-container']//descendant::div[text()=" + day + "]").click();
    }


}
