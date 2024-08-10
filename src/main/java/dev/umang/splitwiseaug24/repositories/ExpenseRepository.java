package dev.umang.splitwiseaug24.repositories;

import dev.umang.splitwiseaug24.models.Expense;
import dev.umang.splitwiseaug24.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
}
