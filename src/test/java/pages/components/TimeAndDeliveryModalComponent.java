package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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
    public TimeAndDeliveryModalComponent openChooseDeliveryTypeModal() {
        chooseDeliveryTypeButton.click();
        addressModal.shouldBe(visible);
        return this;
    }

    public TimeAndDeliveryModalComponent clickAddNewAddress() {
        addNewAddressButton.click();
        return this;
    }

    public TimeAndDeliveryModalComponent setDeliveryAddress(String address) {
        addressInput.setValue(address);
        addressValues.findBy(text(address)).parent().click();
        return this;
    }

    public TimeAndDeliveryModalComponent confirmAddress() {
        button.findBy(text("Выбрать")).click();
        notificationModal.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }


    @Step("Устанавливаем время доставки")
    public TimeAndDeliveryModalComponent setDeliveryTime() {
        deliveryTimeModal.shouldBe(visible, Duration.ofSeconds(10));
        chosenDeliveryTime.click();
        deliveryTimeModal.shouldNotBe(visible);
        return this;
    }
}
