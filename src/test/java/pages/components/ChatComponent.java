package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ChatComponent {
    private SelenideElement
            chatButton = $(".VV_FeedBackShoweToggler2021"),
            chatModal = $(".VV_FeedBackChat"),
            chatHeader = $(".VV_FeedBackChat__Title"),
            chatInput = $(".VV_FeedBackChatTalkForm__input"),
            chatSubmitButton = $(".VV_FeedBackChatTalkForm__Submit"),
            chatCloseButton = $("#feedbackChat .VV_ModalCloser"),
            chatAddFileButton = $("#feedbackChat .VV_FeedBackChatTalkForm__File");

    public ChatComponent openChat() {
        chatButton.click();
        return this;
    }

    public ChatComponent checkChatModal() {
        chatModal.shouldBe(visible);
        chatHeader.shouldHave(text("Чат поддержки"));
        chatAddFileButton.shouldBe(visible);
        return this;
    }

    public ChatComponent insertValueCheck(String value) {
        chatInput.setValue(value);
        chatInput.shouldHave(value(value));
        chatSubmitButton.shouldBe(visible);
        return this;
    }

    public ChatComponent closeChat() {
        chatCloseButton.click();
        chatModal.shouldNotBe(visible);
        return this;
    }
}
