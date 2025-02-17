package com.yourCompanyName.projectName.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target MESSAGE_WELCOME =  Target.the("Message welcome ").located(By.tagName("h2"));
    public static final Target SEARCH =  Target.the("Search ").located(By.xpath("//li[contains(@class , 'search_online')]"));
    public static final Target INPUT_SEARCH =  Target.the("Input search ").located(By.name("username"));
    public static final Target SEARCH_BUTTON =  Target.the("Search button ").located(By.xpath("//input[@value='Search!']"));
    public static final Target ACCOUNT_SEARCHING =  Target.the("Result after search ").located(By.xpath("//h4[contains(@class , 'view_title')]"));
    public static final Target TEXT_BOX_CHAT =  Target.the("Box chat ").located(By.id("contenteditablediv"));
    public static final Target SEND_BUTTON =  Target.the(" Send button ").located(By.xpath("//button[contains(@class , 'msg_send_btn')]"));
    public static final Target NOTIFICATION_BOX =  Target.the("Notification box ").located(By.xpath("//li[contains(@class ,'inbox')]//span"));
    public static final Target LIST_MESSAGE =  Target.the("List massage ").located(By.xpath("//div[contains(@class , 'info-block')]/h4"));
    public static final Target LIST_MESSAGE_INCOMING =  Target.the("List massage incoming ").located(By.xpath("//div[contains(@class , 'incoming_msg')]/descendant::p"));

}
