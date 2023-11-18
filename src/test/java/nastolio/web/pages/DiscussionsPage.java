package nastolio.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DiscussionsPage {
    private ElementsCollection articles = $(".articles").$$(".article");
    private SelenideElement commentInactive = $("#comments").$(".form-control"),
            commentInput = $("#comments").$("[contenteditable=true]"),
            sendComment = $("#comments").$(byText("Отправить")),
            myComment = $("#comments"),
            deleteCommentButton = $("#comments").$("button[title=Удалить]");

    public DiscussionsPage openFirst(){
        articles.first().click();
        return this;
    }

    public DiscussionsPage leftComment(String value){
        commentInactive.click();
        commentInput.sendKeys(value);
        sendComment.click();
        return this;
    }

    public DiscussionsPage deleteComment(){
        deleteCommentButton.doubleClick();
        return this;
    }

    public boolean findMyComment(String value){
        return myComment.$(byText(value)).exists();
    }
}
