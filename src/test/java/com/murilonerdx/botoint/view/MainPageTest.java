package com.murilonerdx.botoint.view;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.murilonerdx.botoint.view.Util.getProp;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    public static boolean baterPonto() throws IOException {
        Configuration.headless = true;

        open("https://www.dimepkairos.com.br/Dimep/Account/Marcacao");
        Configuration.browserSize = "1280x800";
        Configuration.downloadsFolder ="./comprovante";
        Configuration.proxyEnabled = true;

        String username = getProp().getProperty("kairos.username");
        String password = getProp().getProperty("kairos.password");

        $(By.name("UserName")).sendKeys(username);
        $(By.name("Password")).sendKeys(password);

        $(By.className("Pointer")).click();

        if($(By.id("Summary-Field-Index")).innerHtml().contains("Marcação de Ponto inserida com sucesso")){
            File report = $(By.className("LoginForm")).$x("div",6).$x("object").$("a").download();
            clearBrowserLocalStorage();
            closeWebDriver();
            return true;
        }else{
            clearBrowserLocalStorage();
            closeWebDriver();
            return false;
        }
    }
}
