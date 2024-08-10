package dev.umang.splitwiseaug24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private int amount;
    private String description;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
    /*

    settle up A
    fetched A
    list of all expense users corresponding to A
    expnse1, A 100 had_to_pay,
    espense2, A 100 had_to_pay
    expems2, A 500 paid_by

    creating list of unique expenses that A was part of

    expense1
    expens2
    expense3

    expense1
    A 100 had_to_pay,
    B 200, had_to_pay
    C 300, had_to_pay
    A 600, paid_by


    expense2
    A 100 had_to_pay
    A 500 paid_by
    B
    C

    expense3
    A
    B
    C
    D

    expense4
    C
    D


     */

    @ManyToOne
    private Group group;
}

/*
1       1
Expense User => m : 1
m       1


Expense ExpenseUser => 1 : m

Settle up a user

Expense1  -> Coffee -> multiple expenseUsers
Expense2  ->
Expense3  ->
Expense4  ->


List of all expense users for a user :-
Coffee, Kriti, 500, PAID_BY
Coffee, Kriti, 200, HAD_TO_PAY
Dinner, Kriti, 1000, HAD_TO_PAY
Dinner, Kriti, 800, PAID_BY
Goa trip, Kriti, 10,000 , PAID_BY
Goa trip, Kriti, 2,000, HAD_TO_Pay

List of all expenses Kriti was a part of :-
Coffee.
Dinner
Goa Trip...
 */
