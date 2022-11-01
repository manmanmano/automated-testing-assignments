package icd0004;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckboxesPage {

   private final By checkboxesPageLink = By.linkText("Checkboxes");
   private final By checkboxesCollection = By.xpath("//button");

    public void goTo() {
        open("/");
        $(checkboxesPageLink).click();
    }

    public String getPageTitleText() {
        return $("h3").getText();
    }

    public Integer countCheckedCheckboxes() {
        List<SelenideElement> checkboxes = $$(checkboxesCollection);
        int checkedCheckboxesCounter = 0;
        for (SelenideElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkedCheckboxesCounter++;
            }

        }
        return checkedCheckboxesCounter;
    }
}
