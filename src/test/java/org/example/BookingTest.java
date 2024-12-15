package org.example;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Feature("Поиск отелей")
@Story("Проверка фильтрации по количеству звезд")

public class BookingTest {
    @BeforeAll
    static void setUpBaseUrl() {
        System.setProperty("selenide.baseUrl", "http://example.com");
    }
    @Test
    @Description("Поиск отелей в Анталии с фильтром '5 звезд'")
    public void testBookingAntalyaFiveStarFilter() {
        // Шаг 1: Зайти на сайт https://booking.com/
        HomePage homePage = new HomePage();
        homePage.openHomePage();

        // Шаг 2: Ввести в поиске «Анталья»
        String destination = "Анталья";
        SearchResultsPage resultsPage = homePage.searchForDestination(destination);

        // Шаг 3: Нажать на кнопку «Найти»
        // Уже сделано в методе searchForDestination()

        // Шаг 4: Проверить, что в поиске отображается «Анталья»
        resultsPage.verifySearchResultContains(destination);

        // Шаг 5: Выбрать «5 звёзд» в списке «Все фильтры» слева
        int starRating = 5;
        resultsPage.filterByStars(starRating);

        // Шаг 6: Убедиться, что все отели на данной странице имеют 5 звёзд
        resultsPage.assertAllHotelsHaveStars(starRating);
    }
}
