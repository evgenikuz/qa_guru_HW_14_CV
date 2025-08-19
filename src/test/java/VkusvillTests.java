import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.MainPage;

public class VkusvillTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();


    @ParameterizedTest(name = "По поиску {0} первая карточка имеет название товара {0}")
    @ValueSource(strings = {
            "Круассан", "Молоко", "Яйцо"
    })
    @DisplayName("Проверка поиска")
    void searchTest(String searchQuery) {
        mainPage.openPage()
                .search(searchQuery)
                .searchResultCheck(searchQuery);
    }

    @Test
    @DisplayName("Проверка кнопки 'Хочу во ВкусВилл'")
    void jobButtonTest() {
        mainPage.openPage()
                .jobButtonClick()
                .jobButtonClickCheck();
    }

    @Test
    @DisplayName("Проверка чата")
    void chatTest() {
        mainPage.openPage()
                .openChat()
                .checkChatModal()
                .insertValueCheck("Добрый день!")
                .closeChat();
    }

    @Test
    @DisplayName("Проверка выпадающего меню каталога")
    void dropDownMenuTest() {
        mainPage.openPage()
                .dropdownMenuCall()
                .dropdownMenuCheck();
    }

    @Test
    @DisplayName("Проверка выбора адреса доставки")
    void settingDeliveryTypeAndDateTest() {
        mainPage.openPage()
                .openChooseDeliveryTypeModal()
                .clickAddNewAddress()
                .setDeliveryAddress("Красная пл, д. 1")
                .confirmAddress()
                .setDeliveryTime();
    }

    @Test
    @DisplayName("Проверка корзины")
    void addToCartTest() {
        mainPage.openPage()
                .search("Авокадо")
                .searchResultCheck("Авокадо")
                .addToCart()
                .addToCartResultCheck()
                .clickOnCartIcon();
        cartPage.checkItemInCart("260", "Авокадо");
    }
}
