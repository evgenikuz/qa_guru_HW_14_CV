import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class VkusvillTests extends TestBase {
    MainPage mainPage = new MainPage();

//    @Test
//    @DisplayName("Проверка поиска")
//    @Tag("Promo")
//    void searchTest() {
//        mainPage.openPage()
//                .searchCheck("Круассан");
//    }
//
//    @Test
//    @DisplayName("Проверка кнопки 'Хочу во ВкусВилл'")
//    @Tag("Promo")
//    void jobButtonTest() {
//        mainPage.openPage()
//                .jobButtonClick();
//    }
//
//    @Test
//    @DisplayName("Проверка чата")
//    @Tag("Promo")
//    void chatTest() {
//        mainPage.openPage()
//                .openChat()
//                .insertValueCheck("Добрый день!")
//                .closeChat();
//    }
//
//    @Test
//    @DisplayName("Проверка выпадающего меню каталога")
//    @Tag("Promo")
//    void dropDownMenuTest() {
//        mainPage.openPage()
//                .dropdownMenuCheck();
//    }

    @Test
    @DisplayName("Проверка выбора адреса доставки")
    @Tag("Promo")
    void deliveryTypeTest() {
        mainPage.openPage()
                .setDeliveryAddress("Красная пл, д. 1")
                .setDeliveryTime();
    }

    @Test
    @DisplayName("Проверка корзины")
    @Tag("Promo")
    void addToCartTest() {
        mainPage.openPage()
                .searchCheck("Авокадо")
                .addToCart();
    }
}
