package dev.umang.splitwiseaug24.repositories;

import dev.umang.splitwiseaug24.models.ExpenseUser;
import dev.umang.splitwiseaug24.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUserRepository, Long> {
    List<ExpenseUser> findAllByUser(User user);
}

/*
Expense User - > expense, user, amount, had_to_pay / paid_by
 */
