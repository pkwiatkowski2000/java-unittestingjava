package pl.rectorapator.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given (wstępne założenia testu, tworzymy obiekty, ustawiamy stan początkowy, zaślepiamy zależności)
        Account newAccount = new Account();

        //then (asercje, pod warunkiem, gdy wykonamy jakąś operację to ma się coś stać)
        assertFalse(newAccount.isActive(), "Check if new account is not active");
    }

     /*BDD:
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
}
