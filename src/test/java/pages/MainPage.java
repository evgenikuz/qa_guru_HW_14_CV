package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private SelenideElement logoText = $(".HeaderBLogo__LogoText"),
                            searchInput = $(".HeaderSearchBlock__Input"),
                            searchResult = $(".VV21_SearchPage__TitleText"),
                            firstCardInSearch = $(".ProductCard__link"),
                            chatButton = $(".VV_FeedBackShoweToggler2021"),
                            chatModal = $(".VV_FeedBackChat"),
                            chatHeader = $(".VV_FeedBackChat__Title"),
                            chatInput = $(".VV_FeedBackChatTalkForm__input"),
                            chatSubmitButton = $(".VV_FeedBackChatTalkForm__Submit"),
                            chatCloseButton = $("#feedbackChat .VV_ModalCloser"),
                            chatAddFileButton = $("#feedbackChat .VV_FeedBackChatTalkForm__File"),
                            catalogueBatton = $(".HeaderMainCatalogBtn"),
                            dropdownMenu = $(".Container .HeaderMainDMenu__Inner"),
                            addToCartButton = $(".CartButton__inner"),
                            addToCartButtonWithQuantity = $(".ProductCard__cartButton .CartButton__quantityInputFake"),
                            addToCartButtonPrice = $(".ProductCard__cartButton .js-delivery__product__totalprice"),
                            cardIconPrice = $(".js-delivery__basketHeader .js-delivery__basket--totals_products-price"),
                            cartIcon = $(".js-delivery__basketHeader"),
                            chooseDeliveryTypeButton = $(".HeaderATDToggler"),
                            addressModal = $("#js-my-addresses-modal .VV23_RWayModal_Addresses"),
                            addNewAddressButton = $("#js-my-addresses-modal .VV23_RWayModal_Main__AddAddressBtn"),
                            addressInput = $("#js-my-addresses-modal #js-my-addresses-address"),
                            notificationModal = $("#js-notify-container-modal"),
                            deliveryTimeModal = $("#js-delivery-slots-modal .VV23_RWayModal_Services"),
                            chosenDeliveryTime = $("#js-delivery-slots-modal ._checked-title");
    private ElementsCollection button = $$(".VV_Button"),
                                promoHeader = $$("HeaderMainDMenuContentItem__Title"),
                                addressValues = $$(".VV_DMenuContentElement__LinkText");

    public MainPage openPage() {
        open("/");
        logoText.shouldHave(text("ВкусВилл"));
        return this;
    }

    public MainPage searchCheck(String value) {
        searchInput.setValue(value).pressEnter();
        searchResult.shouldHave(text(value));
        firstCardInSearch.shouldHave(attributeMatching("title", ".*" + value + ".*"));
        return this;
    }

    public MainPage jobButtonClick() {
        button.findBy(text("                                 Хочу во ВкусВилл                             ")).click();
        webdriver().shouldHave(url("https://vkusvill.ru/job/"));
        return this;
    }

    public MainPage openChat() {
        chatButton.click();
        chatModal.shouldBe(visible);
        chatHeader.shouldHave(text("Чат поддержки"));
        chatAddFileButton.shouldBe(visible);
        return this;
    }

    public MainPage insertValueCheck(String value) {
        chatInput.setValue(value);
        chatInput.shouldHave(value(value));
        chatSubmitButton.shouldBe(visible);
        return this;
    }

    public MainPage closeChat() {
        chatCloseButton.click();
        chatModal.shouldNotBe(visible);
        return this;
    }

    public MainPage dropdownMenuCheck() {
        catalogueBatton.hover();
        dropdownMenu.shouldBe(visible);
        promoHeader.findBy(text("Акции"));
        return this;
    }

    public MainPage setDeliveryAddress(String address) {
        chooseDeliveryTypeButton.click();
        addressModal.shouldBe(visible);
        addNewAddressButton.click();
        addressInput.setValue(address);
        addressValues.findBy(text(address)).parent().click();
        button.findBy(text("Выбрать")).click();
        notificationModal.shouldBe(visible);
        return this;
    }

    public MainPage setDeliveryTime() {
        deliveryTimeModal.shouldBe(visible);
        chosenDeliveryTime.click();
        deliveryTimeModal.shouldNotBe(visible);
        return this;
    }

    public MainPage addToCart() {
        addToCartButton.click();
        addToCartButtonWithQuantity.shouldHave(text("1"));
        addToCartButtonPrice.shouldHave(text(cardIconPrice.getText()));
        cartIcon.click();
        return this;
    }

}
