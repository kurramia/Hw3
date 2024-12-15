package org.example;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.HotelDetailPage;
import org.example.SearchResultsPage;
import org.example.HomePage;
import java.util.HashMap;
import java.util.Map;
//@Description("Тестирование сайта booking.com")
public class BookingTest2 {
    @BeforeAll
    static void setUpBaseUrl() {
        System.setProperty("selenide.baseUrl", "http://example.com");
    }
    @Test
    @Description("Автоматизация сценария поиска отеля на сайте booking.com")
    public void testBookingScenario() {
        // Шаг 1: Зайти на сайт https://www.booking.com/
        HomePage2 homePage = new HomePage2();
        homePage.openHomePage();

        // Шаг 2: Ввести в поиске любой город (заграничный)
        String destination = "Paris"; // Можно выбрать любой другой город
        SearchResultsPage2 resultsPage = homePage.searchForDestination(destination);

        // Шаг 3: Выбрать случайные даты
        // Даты выбираются автоматически при открытии страницы

        // Шаг 4: Нажать на кнопку «Найти»
        // Уже выполнено в методе searchForDestination()

        // Шаг 5: Навести курсор на первый отель (карточка слева)
        // Не требуется, так как данные берутся сразу со страницы

        // Шаг 6: Сохранить (в переменные) название отеля, количество звезд, среднюю оценку, количество отзывов, стоимость
        Map<String, String> hotelDetails2 = resultsPage.getHotelDetails2();

        // Шаг 7: Нажать на соответствующий маркер на карте
        HotelDetailPage detailPage = resultsPage.clickOnFirstMarker();

        // Шаг 8: На открывшейся странице отеля проверить название отеля, количество звезд, среднюю оценку, количество отзывов и стоимость
        detailPage.checkHotelDetails(hotelDetails2);
    }
}
