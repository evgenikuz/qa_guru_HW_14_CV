package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TimeModalComponent {
    private SelenideElement
            deliveryTimeModal = $("#js-delivery-slots-modal .VV23_RWayModal_Services"),
            chosenDeliveryTime = $("#js-delivery-slots-modal ._checked-title");

    public TimeModalComponent setDeliveryTime() {
        deliveryTimeModal.shouldBe(visible, Duration.ofSeconds(10));
        chosenDeliveryTime.click();
        deliveryTimeModal.shouldNotBe(visible);
        return this;
    }
}
