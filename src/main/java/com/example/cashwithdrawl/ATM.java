package com.example.cashwithdrawl;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Integer, Integer> denominations;

    public ATM(Map<Integer, Integer> denominations) {
        this.denominations = new HashMap<>(denominations);
    }

    public synchronized boolean withdraw(int amount) {
        if (amount <= 0) {
            return false;
        }

        Map<Integer, Integer> tempDenominations = new HashMap<>(this.denominations);
        Map<Integer, Integer> withdrawal = new HashMap<>();

        for (int denomination : tempDenominations.keySet()) {
            int count = tempDenominations.get(denomination);
            int notesRequired = Math.min(amount / denomination, count);

            if (notesRequired > 0) {
                withdrawal.put(denomination, notesRequired);
                amount -= denomination * notesRequired;
                tempDenominations.put(denomination, count - notesRequired);
            }
        }

        if (amount == 0 && withdrawal.size() > 0) {
            // Update ATM denominations
            this.denominations = tempDenominations;
            System.out.println("Withdrawal successful: " + withdrawal);
            return true;
        } else {
            System.out.println("Insufficient denominations in ATM");
            return false;
        }
    }
}

