package com.yourCompanyName.projectName.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class ParameterDefinitions {
    @Managed
    WebDriver driverForUser1 ;

    @Managed
    WebDriver driverForUser2 ;


    Actor username1 = Actor.named("Username_1");
    Actor username2 = Actor.named("Username_2");


    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        username1.can(BrowseTheWeb.with(driverForUser1));
        username2.can(BrowseTheWeb.with(driverForUser2));
    }
}
