package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private SelenideElement cartHeader = $("#js-delivery__basket--notempty .Delivery__Order__BasketHeaderTitle"),
                            itemInCart = $(".Delivery__BasketModal__BasketItem-Name");

    public CartPage checkItemInCart() {
        cartHeader.shouldHave(text("Корзина"));
        itemInCart.shouldHave(text("Авокадо Хасс, 2 шт"));
        return this;
    }
}
