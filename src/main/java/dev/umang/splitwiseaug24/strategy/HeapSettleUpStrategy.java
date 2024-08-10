package dev.umang.splitwiseaug24.strategy;

import dev.umang.splitwiseaug24.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        //iterate through all expenses and find out total extra/
        //lesser amoint paid by every user involved.
        //apply the min/max heap algorithm to settle up everyone
        return null;
    }
}
