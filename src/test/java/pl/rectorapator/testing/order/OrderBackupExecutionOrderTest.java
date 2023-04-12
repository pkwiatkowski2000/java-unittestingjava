package pl.rectorapator.testing.order;

import org.junit.jupiter.api.Test;
import pl.rectorapator.testing.order.Order;
import pl.rectorapator.testing.order.OrderBackup;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException() throws IOException {

        //given
        OrderBackup orderBackup = new OrderBackup();

        //then
        assertThrows(IOException.class, () -> orderBackup.backUpOrder(new Order()));

    }
}
