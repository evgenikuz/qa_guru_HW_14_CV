package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeliveryModalComponent {
    private SelenideElement
            chooseDeliveryTypeButton = $(".HeaderATDToggler"),
            addressModal = $("#js-my-addresses-modal .VV23_RWayModal_Addresses"),
            addNewAddressButton = $("#js-my-addresses-modal .VV23_RWayModal_Main__AddAddressBtn"),
            addressInput = $("#js-my-addresses-modal #js-my-addresses-address"),
            notificationModal = $("#js-notify-container-modal");
    private ElementsCollection button = $$(".VV_Button"),
            addressValues = $$(".VV_DMenuContentElement__LinkText");

    public DeliveryModalComponent openChooseDeliveryTypeModal() {
        chooseDeliveryTypeButton.click();
        addressModal.shouldBe(visible);
        return this;
    }

    public DeliveryModalComponent clickAddNewAddress() {
        addNewAddressButton.click();
        return this;
    }

    public DeliveryModalComponent setDeliveryAddress(String address) {
        addressInput.setValue(address);
        addressValues.findBy(text(address)).parent().click();
        return this;
    }

    public DeliveryModalComponent confirmAddress() {
        button.findBy(text("Выбрать")).click();
        notificationModal.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }
}
