package org.example;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import java.util.HashMap;
import java.util.Map;
public class SearchResultsPage2 {
    public Map<String, String> getHotelDetails2() {
        Map<String, String> hotelDetails2 = new HashMap<>();

        // Название отеля
        String hotelName = $(".sr-hotel__name").getText().trim();
        hotelDetails2.put("hotelName", hotelName);

        // Количество звезд
        String stars = $(".bui-review-score__title").getText().split(" ")[0].trim();
        hotelDetails2.put("stars", stars);

        // Средняя оценка
        String rating = $(".bui-review-score__badge").getText().replace(",", ".").trim();
        hotelDetails2.put("rating", rating);

        // Количество отзывов
        String reviewsCount = $(".bui-review-score__text").getText().split(" ")[0].trim();
        hotelDetails2.put("reviewsCount", reviewsCount);

        // Стоимость
        String price = $(".bui-price-display__value").getText().trim();
        hotelDetails2.put("price", price);

        return hotelDetails2;
    }

    public HotelDetailPage clickOnFirstMarker() {
        $(".map_marker_link").click();
        return new HotelDetailPage();
    }
}
