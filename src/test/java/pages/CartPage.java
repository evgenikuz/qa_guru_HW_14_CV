package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private SelenideElement cartHeader = $("#js-delivery__basket--notempty .Delivery__Order__BasketHeaderTitle"),
                            itemInCart = $(".Delivery__BasketModal__BasketItem-Name"),
                            itemPrice = $(".js-delivery__basket--row__price-sale-value");

    public CartPage checkItemInCart(String price, String item) {
        cartHeader.shouldHave(text("Корзина"));
        itemInCart.shouldHave(partialText(item));
        itemPrice.shouldHave(text(price));
        return this;
    }
}
