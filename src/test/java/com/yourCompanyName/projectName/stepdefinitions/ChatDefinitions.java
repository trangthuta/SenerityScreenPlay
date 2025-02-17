package com.yourCompanyName.projectName.stepdefinitions;

import com.yourCompanyName.projectName.navigation.NavigateTo;
import com.yourCompanyName.projectName.pages.HomePage;
import com.yourCompanyName.projectName.tasks.ChatTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static com.yourCompanyName.projectName.pages.HomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChatDefinitions {
    @Given("{actor} open the website chatib.us")
    public void usernameOpenTheWebsiteChatibUs(Actor actor) {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage()
        );
    }

    @And("{actor} enter a valid username {string} into the username textbox")
    public void username_EnterAValidUsernameIntoTheUsernameTextbox(Actor actor, String username) {
        actor.attemptsTo(
                ChatTask.enterUsername(actor, username)
        );
    }

    @And("{actor} enter a valid password {string} into the password textbox")
    public void username_EnterAValidPasswordIntoThePasswordTextbox(Actor actor, String password) {
        actor.attemptsTo(ChatTask.enterPassword(actor, password));
    }

    @And("{actor} click on login button")
    public void username_ClickOnLoginButton(Actor actor) {
        actor.attemptsTo(
                ChatTask.clickOnLoginButton(actor)
        );
    }

    @And("{actor} login successfully , a welcome message display at home page to welcome {string}")
    public void username_LoginSuccessfullyAWelcomeMessageDisplayAtHomePageToWelcome(Actor actor, String username) {
        actor.attemptsTo(
                WaitUntil.the(SEARCH , isVisible()).forNoMoreThan(10).seconds() ,
                Ensure.that(SEARCH).isDisplayed()
        );
    }

    @And("{actor} click on search icon")
    public void username_ClickOnSearchIcon(Actor actor) {
        actor.attemptsTo(
                ChatTask.clickOnSearchIcon(actor)
        );
    }

    @And("{actor} enter {string} into search input textbox")
    public void username_EnterIntoSearchInputTextbox(Actor actor, String username) {
        actor.attemptsTo(
                ChatTask.inputDateSearch(actor, username)
        );
    }

    @And("{actor} choose value {string} in All Countries dropdown")
    public void username_ChooseValueInAllCountriesDropdown(Actor actor, String country) {
        actor.attemptsTo(
                ChatTask.chooseCountry(actor, country)
        );
    }

    @And("{actor} click on search button")
    public void username_ClickOnSearchButton(Actor actor) {
        actor.attemptsTo(
                ChatTask.clickOnSearchButton(actor)
        );
    }

    @And("{actor} choose account {string} from  searching result")
    public void username_ChooseAccountFromSearchingResult(Actor actor, String username) {
        actor.attemptsTo(
                ChatTask.chooseAccountAfterSearching(actor, username)
        );
    }

    @And("{actor} send message {string} to account {string}")
    public void username_SendMessageToAccount(Actor actor, String msg, String username) {
        actor.attemptsTo(
                WaitUntil.the(TEXT_BOX_CHAT, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TEXT_BOX_CHAT).isDisplayed(),
                Ensure.that(SEND_BUTTON).isDisplayed(),
                ChatTask.sendMessageToOtherAccount(actor, msg, username)
        );
    }

    @Then("{actor} received a message {string} from account {string}")
    public void username_ReceivedAMessageFromAccount(Actor actor, String msg, String username) {
        List<String> listMessageText = new ArrayList<>();
        ListOfWebElementFacades listMessageIncoming = LIST_MESSAGE_INCOMING.resolveAllFor(actor);
        for (WebElementFacade elementFacade : listMessageIncoming) {
            listMessageText.add(elementFacade.getText());
            System.out.println(elementFacade.getText());
        }
        System.out.println(listMessageText.get(listMessageIncoming.size()) + "-------------------------------");

        String newMessage = listMessageText.get(listMessageIncoming.size());
        actor.attemptsTo(
                WaitUntil.the(LIST_MESSAGE, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(LIST_MESSAGE).isDisplayed(),
                ChatTask.clickOnSender(actor, msg, username),
                WaitUntil.the(LIST_MESSAGE_INCOMING, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(LIST_MESSAGE_INCOMING).isDisplayed(),
                Ensure.that(newMessage.equals(msg)).isTrue()
        );

    }

    @Then("{actor} have inbox notification and click on that")
    public void username_HaveInboxNotification(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(NOTIFICATION_BOX, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(NOTIFICATION_BOX).isDisplayed(),
                ChatTask.receivedANotification(actor)
        );
    }
}
