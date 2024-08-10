package dev.umang.splitwiseaug24.dtos;

import dev.umang.splitwiseaug24.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private List<Expense> transactionsList;
}
