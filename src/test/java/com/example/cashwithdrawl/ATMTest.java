package com.example.cashwithdrawl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ATMTest {

    @Test
    public void testWithdrawal() {
        Map<Integer, Integer> denominations = new HashMap<>();
        denominations.put(100, 10);
        denominations.put(200, 10);
        denominations.put(500, 5);
        ATM atm = new ATM(denominations);
        assertTrue(atm.withdraw(700)); 
    }

    @Test
    public void testWithdrawalWithZeroAmount() {
        Map<Integer, Integer> denominations = new HashMap<>();
        denominations.put(100, 10);
        denominations.put(200, 10);
        denominations.put(500, 5);
        ATM atm = new ATM(denominations);
        assertFalse(atm.withdraw(0)); 
    }

    @Test
    public void testWithdrawalWithNegativeAmount() {
        Map<Integer, Integer> denominations = new HashMap<>();
        denominations.put(100, 10);
        denominations.put(200, 10);
        denominations.put(500, 5);
        ATM atm = new ATM(denominations);
        assertFalse(atm.withdraw(-500)); 
    }
}

