package org.example.Helper;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;

public class WaitHelper {
    private static int TIME_OUT = 10;
    private static String DEFAULT_ALIAS = "Have error when wait element";

    public static void WaitElementDisplayed(WebElement element) {
        await().alias(DEFAULT_ALIAS)
                .atMost(TIME_OUT, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed, is(true));
    }
    public static void WaitElementEnabled(WebElement element) {
        await().alias(DEFAULT_ALIAS)
                .atMost(TIME_OUT, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isEnabled, is(true));
    }
}
