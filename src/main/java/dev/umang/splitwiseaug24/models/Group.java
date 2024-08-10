package dev.umang.splitwiseaug24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class Group extends BaseModel{
    private String name;

    private String description;

    @ManyToMany
    private List<User> memberList;

    @ManyToOne
    private User createdBy; // Admin

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}

/*
1       m
Group User => m : m
m        1

1       1
Group User => m : 1
m        1

1       m
Group Expense
1        1
 */