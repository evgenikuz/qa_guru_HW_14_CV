package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TimeAndDeliveryModalComponent {
    private SelenideElement
            chooseDeliveryTypeButton = $(".HeaderATDToggler"),
            addressModal = $("#js-my-addresses-modal .VV23_RWayModal_Addresses"),
            addNewAddressButton = $("#js-my-addresses-modal .VV23_RWayModal_Main__AddAddressBtn"),
            addressInput = $("#js-my-addresses-modal #js-my-addresses-address"),
            notificationModal = $("#js-notify-container-modal"),
            deliveryTimeModal = $("#js-delivery-slots-modal .VV23_RWayModal_Services"),
            chosenDeliveryTime = $("#js-delivery-slots-modal ._checked-title");
    private ElementsCollection button = $$(".VV_Button"),
            addressValues = $$(".VV_DMenuContentElement__LinkText");

    @Step("Устанавливаем адрес доставки")
    public TimeAndDeliveryModalComponent setDeliveryAddress(String address) {
        chooseDeliveryTypeButton.click();
        addressModal.shouldBe(visible);
        addNewAddressButton.click();
        addressInput.setValue(address);
        addressValues.findBy(text(address)).parent().click();
        button.findBy(text("Выбрать")).click();
        notificationModal.shouldBe(visible);
        return this;
    }
    @Step("Устанавливаем время доставки")
    public TimeAndDeliveryModalComponent setDeliveryTime() {
        deliveryTimeModal.shouldBe(visible);
        chosenDeliveryTime.click();
        deliveryTimeModal.shouldNotBe(visible);
        return this;
    }
}
