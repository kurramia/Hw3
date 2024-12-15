package org.example;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import java.util.HashMap;
import java.util.Map;
public class HotelDetailPage {
    public void checkHotelDetails(Map<String, String> details) {
        // Название отеля
        String actualHotelName = $("#hp_hotel_name").getText().trim();
        String expectedHotelName = details.get("hotelName");
        $(actualHotelName).shouldHave(text(expectedHotelName));

        // Количество звезд
        String actualStars = $(".hp__hotel_ratings > span").getText().split(" ")[0].trim();
        String expectedStars = details.get("stars");
        $(actualStars).shouldHave(text(expectedStars));

        // Средняя оценка
        String actualRating = $(".js--hp-gallery-scoring > div:nth-child(1) > div").getText().replace(",", ".").trim();
        String expectedRating = details.get("rating");
        $(actualRating).shouldHave(text(expectedRating));

        // Количество отзывов
        String actualReviewsCount = $(".bui-review-score__text").getText().split(" ")[0].trim();
        String expectedReviewsCount = details.get("reviewsCount");
        $(actualReviewsCount).shouldHave(text(expectedReviewsCount));

        // Стоимость
        String actualPrice = $(".prco-txt-emphasize").getText().trim();
        String expectedPrice = details.get("price");
        $(actualPrice).shouldHave(text(expectedPrice));
    }
}
