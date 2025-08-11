import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.Components.ChatComponent;
import pages.Components.TimeAndDeliveryModalComponent;
import pages.MainPage;

public class VkusvillTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    ChatComponent chatComponent = new ChatComponent();
    TimeAndDeliveryModalComponent timeAndDeliveryModalComponent = new TimeAndDeliveryModalComponent();

    @ParameterizedTest(name = "По поиску {0} первая карточка имеет название товара {0}")
    @ValueSource(strings = {
            "Круассан", "Молоко", "Яйцо"
    })
    @DisplayName("Проверка поиска")
    @Tag("Promo")
    void searchTest(String searchQuery) {
        mainPage.openPage()
                .searchCheck(searchQuery);
    }

    @Test
    @DisplayName("Проверка кнопки 'Хочу во ВкусВилл'")
    @Tag("Promo")
    void jobButtonTest() {
        mainPage.openPage()
                .jobButtonClick();
    }

    @Test
    @DisplayName("Проверка чата")
    @Tag("Promo")
    void chatTest() {
        mainPage.openPage();
        chatComponent.openChat()
                .insertValueCheck("Добрый день!")
                .closeChat();
    }

    @Test
    @DisplayName("Проверка выпадающего меню каталога")
    @Tag("Promo")
    void dropDownMenuTest() {
        mainPage.openPage()
                .dropdownMenuCheck();
    }

    @Test
    @DisplayName("Проверка выбора адреса доставки")
    @Tag("Promo")
    void deliveryTypeTest() {
        mainPage.openPage();
        timeAndDeliveryModalComponent.setDeliveryAddress("Красная пл, д. 1")
                .setDeliveryTime();
    }

    @Test
    @DisplayName("Проверка корзины")
    @Tag("Promo")
    void addToCartTest() {
        mainPage.openPage()
                .searchCheck("Авокадо")
                .addToCart();
        cartPage.checkItemInCart("260", "Авокадо");
    }
}
