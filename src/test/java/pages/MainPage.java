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
                            catalogueBatton = $(".HeaderMainCatalogBtn"),
                            dropdownMenu = $(".Container .HeaderMainDMenu__Inner"),
                            addToCartButton = $(".CartButton__inner"),
                            addToCartButtonWithQuantity = $(".ProductCard__cartButton .CartButton__quantityInputFake"),
                            addToCartButtonPrice = $(".ProductCard__cartButton .js-delivery__product__totalprice"),
                            cardIconPrice = $(".js-delivery__basketHeader .js-delivery__basket--totals_products-price"),
                            cartIcon = $(".js-delivery__basketHeader");
    private ElementsCollection button = $$(".VV_Button"),
                                promoHeader = $$("HeaderMainDMenuContentItem__Title");
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

    public MainPage dropdownMenuCheck() {
        catalogueBatton.hover();
        dropdownMenu.shouldBe(visible);
        promoHeader.findBy(text("Акции"));
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
