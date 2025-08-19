package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ChatComponent;
import pages.components.DeliveryModalComponent;
import pages.components.TimeModalComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private SelenideElement logoText = $(".HeaderBLogo__LogoText"),
                            searchInput = $(".HeaderSearchBlock__Input"),
                            searchResult = $(".VV21_SearchPage__TitleText"),
                            firstCardInSearch = $(".ProductCard__link"),
                            catalogueBatton = $(".HeaderMainCatalogBtn"),
                            dropdownMenu = $(".Container .HeaderMainDMenu__Inner"),
                            addToCartButton = $(".CartButton__inner"),
                            addToCartButtonWithQuantity = $(".ProductCard__cartButton .CartButton__quantityInputFake"),
                            addToCartButtonPrice = $(".ProductCard__cartButton .js-delivery__product__totalprice"),
                            cardIconPrice = $(".js-delivery__basketHeader .js-delivery__basket--totals_products-price"),
                            cartIcon = $("._cart a");
    private ElementsCollection button = $$(".VV_Button"),
                                promoHeader = $$("HeaderMainDMenuContentItem__Title");

    DeliveryModalComponent deliveryModalComponent = new DeliveryModalComponent();
    TimeModalComponent timeModalComponent = new TimeModalComponent();
    ChatComponent chatComponent = new ChatComponent();

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("/");
        logoText.shouldHave(text("ВкусВилл"));
        return this;
    }
    @Step("Ищем в поисковой строке значение")
    public MainPage search(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Проверяем результат поиска")
    public MainPage searchResultCheck(String value) {
        searchResult.shouldHave(text(value));
        firstCardInSearch.shouldHave(attributeMatching("title", ".*" + value + ".*"));
        return this;
    }

    @Step("Кликаем по кнопке 'Хочу во ВкусВилл'")
    public MainPage jobButtonClick() {
        button.findBy(text("Хочу во ВкусВилл")).click();
        return this;
    }

    @Step("Проверяем открытие страницы вакансий")
    public MainPage jobButtonClickCheck() {
        webdriver().shouldHave(url("https://vkusvill.ru/job/"));
        return this;
    }

    @Step("Наводим курсор на каталоги")
    public MainPage dropdownMenuCall() {
        catalogueBatton.hover();
        return this;
    }

    @Step("Проверяем выпадающее меню")
    public MainPage dropdownMenuCheck() {
        dropdownMenu.shouldBe(visible);
        promoHeader.findBy(text("Акции"));
        return this;
    }

    @Step("Добавляем товар в корзину")
    public MainPage addToCart() {
        addToCartButton.click();
        return this;
    }

    @Step("Проверяем добавление в корзину")
    public MainPage addToCartResultCheck() {
        addToCartButtonWithQuantity.shouldHave(text("1"));
        addToCartButtonPrice.shouldHave(text(cardIconPrice.getText()));
        return this;
    }

    @Step("Кликаем по иконке корзины")
    public MainPage clickOnCartIcon() {
        cartIcon.click();
        return this;
    }

    @Step("Открываем окно выбора способа доставки")
    public MainPage openChooseDeliveryTypeModal() {
        deliveryModalComponent.openChooseDeliveryTypeModal();
        return this;
    }

    @Step("Клик по кнопке 'Добавить новый адрес'")
    public MainPage clickAddNewAddress() {
        deliveryModalComponent.clickAddNewAddress();
        return this;
    }

    @Step("Устанавливаем адрес доставки")
    public MainPage setDeliveryAddress(String address) {
        deliveryModalComponent.setDeliveryAddress(address);
        return this;
    }

    @Step("Подтверждаем адрес доставки")
    public MainPage confirmAddress() {
        deliveryModalComponent.confirmAddress();
        return this;
    }

    @Step("Устанавливаем время доставки")
    public MainPage setDeliveryTime() {
        timeModalComponent.setDeliveryTime();
        return this;
    }

    @Step("Кликаем по иконке чата в правом нижнем углу")
    public MainPage openChat() {
        chatComponent.openChat();
        return this;
    }

    @Step("Проверяем открытие модального окна чата")
    public MainPage checkChatModal() {
        chatComponent.checkChatModal();
        return this;
    }

    @Step("Вводим текст сообщения в поле ввода в чате")
    public MainPage insertValueCheck(String message) {
        chatComponent.insertValueCheck(message);
        return this;
    }

    @Step("Закрываем чат")
    public MainPage closeChat() {
        chatComponent.closeChat();
        return this;
    }
}
