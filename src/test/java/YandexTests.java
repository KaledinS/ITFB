import org.junit.Test;

import java.io.IOException;

public class YandexTests extends TestBase {

    @Test
    public void test() throws InterruptedException {

        app.navigate().goToCategory("Товары для животных", 1, "Лакомства");
        app.market().priceFilter("50", "150");
        app.market().chooseDeliveryOn();
        app.market().chooseMaker("Dreamies");

        app.market().waiting();

        app.market().getProduct(0);

        app.market().waiting();

        app.navigate().back();
        app.market().deleteMaker("Dreamies");
        app.market().chooseMaker("Мнямс");

        app.market().waiting();

        app.market().getProduct(1);
        app.navigate().goToCompareProducts();
        app.market().checkPriceSumm();
        app.market().checkElementDisplayedTrue("Dreamies");
        app.market().delete(1);
        app.market().checkElementDisplayedFalse("Dreamies");
        app.market().deleteAll();
    }
}
