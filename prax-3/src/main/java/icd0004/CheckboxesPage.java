package icd0004;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage {

   private final By checkboxesPageLink = By.linkText("Checkboxes");
   private final By checkboxesCollection = By.xpath("//checkbox");

    public void goTo() {
        open("/");
        $(checkboxesPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public Integer countCheckedCheckboxes() {
        int checkedCheckboxesCounter = 0;
        for (SelenideElement checkbox : $$(checkboxesCollection)) {
            if (checkbox.isSelected()) {
                checkedCheckboxesCounter++;
            }
        }
        System.out.println(checkedCheckboxesCounter);
        return checkedCheckboxesCounter;
    }
}
