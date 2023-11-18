package nastolio.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PremiumPage {
    private SelenideElement header = $(byText("Поддерживай развитие сайта и получай приятные бонусы")),
            subscribe = $$("button").findBy(text("Подключить за 199 рублей"));

    public boolean checkHeader(){
        return header.isDisplayed();
    }

    public boolean checkSubscribeButton(){
        return subscribe.isDisplayed();
    }
}
