package dev.umang.splitwiseaug24.services;

import dev.umang.splitwiseaug24.models.Expense;
import dev.umang.splitwiseaug24.models.ExpenseUser;
import dev.umang.splitwiseaug24.models.Group;
import dev.umang.splitwiseaug24.models.User;
import dev.umang.splitwiseaug24.repositories.ExpenseRepository;
import dev.umang.splitwiseaug24.repositories.ExpenseUserRepository;
import dev.umang.splitwiseaug24.repositories.GroupRepository;
import dev.umang.splitwiseaug24.repositories.UserRepository;
import dev.umang.splitwiseaug24.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository){
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId){
        /*
        1. Get the user object from the User table
        2. Get all expenses this user was a part of.
        3. Iterate through all expenses and find out total extra/
            lesser amount paid by every user involved.
        5. apply the min/max heap algorithm to settle up everyone
         */

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new RuntimeException("Invalid user " + userId);
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for(ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        /*
        expense 1 -> List (kriti, 100, had_to_pay, umang, 500, paid_by....)
        expense 2
        expense 3
        expense 4
         */

        //Settle up the expenses
        List<Expense> transactionsToBeDone = settleUpStrategy.settleUp(expenses.stream().toList());

        List<Expense> expensesToReturn = new ArrayList<>();

        /*
        Expense - dummy expene
        amount
        expense user -> user, amount, expense,
        A -> + 1000
        B -> - 500
        C
        D
        E
        Transactions to be perfromed have atrsnactipns class where you have sender reveover a,poitn
        A - > B 1000 =>
        c - >D 200 =>
        ...
        1000, A,
         */

        for(Expense expense:transactionsToBeDone){
            for(ExpenseUser expenseUser:expense.getExpenseUsers()){
                if(expenseUser.getUser().equals(user)){
                    expensesToReturn.add(expenseUser.getExpense());
                }
            }
        }

        return expensesToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId){
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if(optionalGroup.isEmpty()){
            throw new RuntimeException("Group is invalid " + groupId);
        }

        Group group = optionalGroup.get();

        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        return settleUpStrategy.settleUp(expenses);
    }
}
