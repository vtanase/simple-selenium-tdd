package com.vlad.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vlad.error.Errors;
import com.vlad.integration.page.LoginPage;

public class LoginIT {

  private static final String LOGIN_URL = "http://localhost:8080/simple-tdd-webapp/login";

  private WebDriver driver;

  @Before
  public void setUp() {
    this.driver = new FirefoxDriver();
  }

  @After
  public void tearDown() {
    this.driver.close();
  }

  @Test
  public void testCanLogin() {
    driver.get(LOGIN_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("vtanase", "vtanase");
  }

  @Test
  public void testLoginFailsWithBadUsername() {
    driver.get(LOGIN_URL);
    LoginPage loginPage = new LoginPage(driver).loginFail("badUser", "badPass");
    assertThat(loginPage.getError(), equalTo(Errors.LOGIN_FAILED));
  }

}
