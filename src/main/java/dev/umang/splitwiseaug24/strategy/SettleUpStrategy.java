package dev.umang.splitwiseaug24.strategy;

import dev.umang.splitwiseaug24.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
    /*
    Given a list of expenses, the function should return
    the transactions to be done in order to settle up all expenses.
     */
}
