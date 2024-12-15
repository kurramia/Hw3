package org.example;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class HomePage {
    public void openHomePage() {
        open("https://www.booking.com");
    }

    public SearchResultsPage searchForDestination(String destination) {
        $("#ss").setValue(destination);
        $(".sb-searchbox__button").click();
        return new SearchResultsPage();
    }
}
