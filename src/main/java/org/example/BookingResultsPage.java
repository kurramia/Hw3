package org.example;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class BookingResultsPage {
    public void selectFiveStarFilter() {
        $("[data-filters-group='class'] .filter-item:nth-child(5)").scrollTo().click();
    }

    public void verifyAllHotelsAreFiveStars() {
        ElementsCollection hotelListings =

                $$(".sr_item");
        List<String> starRatings = hotelListings.filter(visible)
                .texts()
                .stream()
                .map(hotel -> hotel.split("\n")[1])
                .toList();

        starRatings.forEach(starRating -> {
            if (!starRating.contains("5 звезд")) {
                throw new AssertionError("Не все отели имеют рейтинг 5 звезд.");
            }
        });
    }
}
