package com.yourCompanyName.projectName.tasks;

import com.yourCompanyName.projectName.pages.HomePage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.yourCompanyName.projectName.pages.HomePage.*;
import static com.yourCompanyName.projectName.pages.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;

public class ChatTask {
    public static Performable enterUsername(Actor actor, String username){
        return Task.where("{actor} enter a valid username {string} into the username textbox",
                Enter.theValue(username)
                        .into(USERNAME_LOGIN)
        );
    }

    public static Performable enterPassword(Actor actor, String pw){
        return Task.where("{actor} enter a valid password {string} into the password textbox",
                Enter.theValue(pw)
                        .into(PASSWORD_LOGIN)
        );
    }

    public static Performable clickOnLoginButton(Actor actor){
        return Task.where("{actor} click on login button",
                Click.on(LOGIN_BUTTON)
        );
    }


    public static Performable clickOnSearchIcon(Actor actor){
        WaitUntil.the(SEARCH , isVisible()).forNoMoreThan(10).seconds() ;
        return Task.where("{actor} click on search icon",
                Click.on(SEARCH)
        );
    }

    public static Performable inputDateSearch(Actor actor, String username){
        WaitUntil.the(INPUT_SEARCH , isVisible()).forNoMoreThan(10).seconds() ;
        return Task.where("{actor} enter {string} into search input textbox",
                Enter.theValue(username).into(INPUT_SEARCH)
        );
    }

    public static Performable chooseCountry(Actor actor, String country){
        return Task.where("{actor} choose value {string} in All Countries dropdown",
                SelectFromOptions.byVisibleText(country).from("#country")
        );
    }

    public static Performable clickOnSearchButton(Actor actor){
        return Task.where("{actor} click on search buttonn",
                Click.on(SEARCH_BUTTON)
        );
    }

    public static Performable chooseAccountAfterSearching(Actor actor , String username){
        WaitUntil.the( ACCOUNT_SEARCHING, isVisible()).forNoMoreThan(10).seconds() ;
        return Task.where("{actor} choose account {string} from  searching result",
                Click.on(ACCOUNT_SEARCHING)
        );
    }

    public static Performable sendMessageToOtherAccount(Actor actor , String msg , String username){
        return Task.where("{actor} send message {string} to account {string}",
                Enter.theValue(msg).into(TEXT_BOX_CHAT) ,
                Click.on(SEND_BUTTON)
        );
    }

    public static Performable receivedANotification(Actor actor){
        return Task.where("{actor} have inbox notification and click on that}",
                Click.on(NOTIFICATION_BOX)
        );
    }

    public static Performable clickOnSender(Actor actor , String msg , String usernameSend){
        ListOfWebElementFacades  listMessage = LIST_MESSAGE.resolveAllFor(actor) ;
        for (WebElementFacade elementFacade : listMessage){
            if(elementFacade.getText().equals(usernameSend)){
                elementFacade.click();
                break;
            }
        }
        return Task.where("{actor} received a message {string} from account {string}}"
        );
    }

//    public static Performable verifyMessageReceived(Actor actor , String msg , String usernameSend){
//        WebElementFacade  element ;
//        ListOfWebElementFacades  listMessageIncoming = LIST_MESSAGE_INCOMING.resolveAllFor(actor) ;
//        for (WebElementFacade elementFacade : listMessageIncoming){
//            if(elementFacade.getText().equals(msg)){
//                element = elementFacade ;
//                break;
//            }
//        }
//        return Task.where("{actor} received a message {string} from account {string}}"
//        );
//    }
}
