package pl.rectorapator.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {
        //given (wstępne założenia testu, tworzymy obiekty, ustawiamy stan początkowy, zaślepiamy zależności)
        Account newAccount = new Account();

        //then (asercje, pod warunkiem, gdy wykonamy jakąś operację to ma się coś stać)
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
    }

    /*
    Konwencja:

    //given (wstępne założenia testu, tworzymy obiekty, ustawiamy stan początkowy, zaślepiamy zależności)
    //when (operacje, które chcemy wykonać)
    //then (asercje, pod warunkiem, gdy wykonamy jakąś operację to ma się coś stać)

    BDD:
         1.Testowanie jednej funkcjonalności, jednej ścieżki wykonania
         2.W nazwach testów unikamy sformułowań AND i OR
     */

    @Test
    void AccountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());

        //when (operacje, które chcemy wykonać)
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("Krakowska", "67c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
    }
}
