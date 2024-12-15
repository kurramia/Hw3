package org.example;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.HashMap;
import java.util.Map;
public class SearchResultsPage
{
    public SearchResultsPage verifySearchResultContains(String expectedText) {
        $("[data-store='application/hotel_list_page']").shouldHave(text(expectedText));
        return this;
    }

    public SearchResultsPage filterByStars(int stars) {

        $$(".filteritem .filtercheckbox").findBy(text(stars + " звезды")).click();
        return this;
    }

    public SearchResultsPage assertAllHotelsHaveStars(int stars) {

        $$(".sr_item .bui-review-score__title").forEach(element -> element.shouldHave(text(stars + " звезда")));
        return this;
    }
}
