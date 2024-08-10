package dev.umang.splitwiseaug24.controllers;

import dev.umang.splitwiseaug24.dtos.SettleUpGroupRequestDTO;
import dev.umang.splitwiseaug24.dtos.SettleUpGroupResponseDTO;
import dev.umang.splitwiseaug24.dtos.SettleUpUserRequestDTO;
import dev.umang.splitwiseaug24.dtos.SettleUpUserResponseDTO;
import dev.umang.splitwiseaug24.models.Expense;
import dev.umang.splitwiseaug24.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }
    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO settleUpUserRequestDTO){

        List<Expense> expenseList = settleUpService.settleUpUser(settleUpUserRequestDTO.getUserId());

        SettleUpUserResponseDTO settleUpUserResponseDTO = new SettleUpUserResponseDTO();
        settleUpUserResponseDTO.setTransactionsList(expenseList);

        return settleUpUserResponseDTO;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO settleUpGroupRequestDTO){
        return null;
    }
}
