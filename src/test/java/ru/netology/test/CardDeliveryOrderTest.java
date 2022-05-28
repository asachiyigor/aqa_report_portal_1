package ru.netology.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryOrderTest {

    private static Faker faker;
    private int firstDay = 4;
    private int secondDay = 6;

    String firstDayDelivery = LocalDate.now()
            .plusDays(firstDay)
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    String secondDayDelivery = LocalDate.now()
            .plusDays(secondDay)
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    String IncorrectDayDelivery = LocalDate.now()
            .plusDays(1)
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
    void shouldShowErrorWithIncorrectData() throws IOException {

        $("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").sendKeys(IncorrectDayDelivery);
        $("[name='name']").setValue(DataGenerator.generateName());
        $("[name='phone']").setValue(DataGenerator.generatePhone());
        $("[placeholder='Город']").setValue(DataGenerator.generateCity());
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id='date'].input_invalid.input__sub")
                .$(withText("Заказ на выбранную дату невозможен"));
    }

    @Test
    void shouldSuccessfulRescheduleMeeting() throws IOException {

        $("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").sendKeys(firstDayDelivery);
        $("[name='name']").setValue(DataGenerator.generateName());
        $("[name='phone']").setValue(DataGenerator.generatePhone());
        $("[placeholder='Город']").setValue(DataGenerator.generateCity());
        $("[data-test-id='agreement']").click();
        $(".button").click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на "
                + firstDayDelivery));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondDayDelivery);
        $$("button").find(exactText("Запланировать")).click();
        $("[data-test-id='replan-notification']").shouldBe(visible);
        $$("button").find(exactText("Перепланировать")).click();
        $("div.notification__content").shouldBe(visible, Duration.ofSeconds(3)).shouldHave(text("Встреча успешно запланирована на " + secondDayDelivery));
    }
}
