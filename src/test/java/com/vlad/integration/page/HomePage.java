package com.vlad.integration.page;

import org.openqa.selenium.WebDriver;

public class HomePage {

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    if (!"Welcome".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the homepage!");
    }
  }

}
