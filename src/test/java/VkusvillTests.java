import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.components.ChatComponent;
import pages.components.TimeAndDeliveryModalComponent;
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
    void searchTest(String searchQuery) {
        mainPage.openPage()
                .searchCheck(searchQuery);
    }

    @Test
    @DisplayName("Проверка кнопки 'Хочу во ВкусВилл'")
    void jobButtonTest() {
        mainPage.openPage()
                .jobButtonClick();
    }

    @Test
    @DisplayName("Проверка чата")
    void chatTest() {
        mainPage.openPage();
        chatComponent.openChat()
                .insertValueCheck("Добрый день!")
                .closeChat();
    }

    @Test
    @DisplayName("Проверка выпадающего меню каталога")
    void dropDownMenuTest() {
        mainPage.openPage()
                .dropdownMenuCheck();
    }

    @Test
    @DisplayName("Проверка выбора адреса доставки")
    void deliveryTypeTest() {
        mainPage.openPage();
        timeAndDeliveryModalComponent.setDeliveryAddress("Красная пл, д. 1")
                .setDeliveryTime();
    }

    @Test
    @DisplayName("Проверка корзины")
    void addToCartTest() {
        mainPage.openPage()
                .searchCheck("Авокадо")
                .addToCart();
        cartPage.checkItemInCart("260", "Авокадо");
    }
}
