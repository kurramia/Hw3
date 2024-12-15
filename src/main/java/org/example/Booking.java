package org.example;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
public class Booking {
    public void open() {
        Selenide.open("https://booking.com/");
    }

    public void enterDestination(String destination) {
        $(By.id("ss")).setValue(destination);
    }

    public void clickSearchButton() {
        $(By.xpath("//button[@type='submit']")).click();
    }

    public void verifyDestinationIsDisplayed(String expectedDestination) {
        $(".bui-header__text").shouldHave(text(expectedDestination));
    }
}
