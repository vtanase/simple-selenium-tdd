package com.vlad.integration.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

  private WebDriver driver;

  private WebElement usernameInput;
  private WebElement passwordInput;
  private WebElement submitButton;
  private WebElement errorContainer;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    if (!"Login".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the login page!");
    }
    usernameInput = driver.findElement(By.name("username"));
    passwordInput = driver.findElement(By.name("password"));
    submitButton = driver.findElement(By.id("submit"));
    errorContainer = driver.findElement(By.id("errors"));
  }

  public LoginPage typeUsername(String username) {
    usernameInput.sendKeys(username);
    return this;
  }

  public LoginPage typePassword(String password) {
    passwordInput.sendKeys(password);
    return this;
  }

  public void submitLogin() {
    submitButton.submit();
  }

  public HomePage login(String username, String password) {
    performLogin(username, password);
    // goto HomePage
    return new HomePage(driver);
  }

  public LoginPage loginFail(String username, String password) {
    performLogin(username, password);
    // stay on Login
    return new LoginPage(driver);
  }

  private void performLogin(String username, String password) {
    this.typeUsername(username);
    this.typePassword(password);
    this.submitLogin();
  }

  public String getError() {
    return this.errorContainer.getText();
  }
}
