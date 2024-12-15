package org.example;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class HomePage2 {
    private final String url = "https://www.booking.com/";

    public void openHomePage() {
        open(url);
    }

    public SearchResultsPage2 searchForDestination(String destination) {
        $("#ss").setValue(destination);
        $(".sb-searchbox__button").click();
        return new SearchResultsPage2();
    }
}
