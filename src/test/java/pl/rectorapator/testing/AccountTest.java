package pl.rectorapator.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/*
    Konwencja:

    //given (wstępne założenia testu, tworzymy obiekty, ustawiamy stan początkowy, zaślepiamy zależności)
    //when (operacje, które chcemy wykonać)
    //then (asercje, pod warunkiem, gdy wykonamy jakąś operację to ma się coś stać)

    BDD:
         1.Testowanie jednej funkcjonalności, jednej ścieżki wykonania
         2.W nazwach testów unikamy sformułowań AND i OR
     */

@Tag("fries")
class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {

        //given (wstępne założenia testu, tworzymy obiekty, ustawiamy stan początkowy, zaślepiamy zależności)
        Account newAccount = new Account();

        //then (asercje, pod warunkiem, gdy wykonamy jakąś operację to ma się coś stać)
        assertFalse(newAccount.isActive(), "Check if new account is not active");
        assertThat(newAccount.isActive(), equalTo(false)); //Hamcrest
        assertThat(newAccount.isActive(), is(false)); //Hamcrest
        assertThat(newAccount.isActive()).isFalse(); //assertJ
    }

    @Test
    void AccountShouldBeActiveAfterActivation() {

        //given
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());

        //when (operacje, które chcemy wykonać)
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(), equalTo(true)); //Hamcrest
        assertThat(newAccount.isActive()).isTrue(); //assertJ

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address, nullValue()); //Hamcrest
        assertThat(address).isNull(); //assertJ
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
        assertThat(defaultAddress, is(notNullValue())); //Hamcrest
        assertThat(defaultAddress, notNullValue()); //Hamcrest
        assertThat(defaultAddress).isNotNull(); //assertJ
    }

    @RepeatedTest(3)
    void newAccountWithNotNullAddressShouldBeActive() {

        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }
}
