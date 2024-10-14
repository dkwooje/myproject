package com.TeamNull.LostArk.LostArk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Question1")
    @Check(constraints = "Question1 BETWEEN 1 AND 5")
    private int question1;

    @Column(name = "Question2")
    @Check(constraints = "Question2 BETWEEN 1 AND 5")
    private int question2;

    @Column(name = "Question3")
    @Check(constraints = "Question3 BETWEEN 1 AND 5")
    private int question3;

    @Column(name = "Question4")
    @Check(constraints = "Question4 BETWEEN 1 AND 5")
    private int question4;

    @Column(name = "Question5")
    @Check(constraints = "Question5 BETWEEN 1 AND 5")
    private int question5;

    @Column(name = "Question6")
    @Check(constraints = "Question6 BETWEEN 1 AND 5")
    private int question6;

    @Column(name = "Question7")
    @Check(constraints = "Question7 BETWEEN 1 AND 5")
    private int question7;

    @Column(name = "Question8")
    @Check(constraints = "Question8 BETWEEN 1 AND 5")
    private int question8;

    @Column(name = "Question9")
    @Check(constraints = "Question9 BETWEEN 1 AND 5")
    private int question9;

    @Column(name = "Question10")
    @Check(constraints = "Question10 BETWEEN 1 AND 5")
    private int question10;

}
