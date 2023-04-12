package pl.rectorapator.testing.order;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pl.rectorapator.testing.Meal;
import pl.rectorapator.testing.order.Order;
import pl.rectorapator.testing.order.OrderBackup;

import java.io.FileNotFoundException;
import java.io.IOException;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    //BeforeAll wymaga, aby metoda nad którą się znajduje była metodą statyczną

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {

        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backUpOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");

    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
