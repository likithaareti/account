package com.unt.account.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Account implements Comparable<Account>{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;
    @Column(nullable = false)
    private String accountType;
    @Column
    private String accountStatus;
    @Column
    @NotEmpty(message = "Need to enter an year for account creation")
    private Integer accountCreationYear;

    @Override
    public int compareTo(Account o) {
        //return (int)(Optional.ofNullable(this.accountCreationYear).orElse(0)-Optional.ofNullable(o.accountCreationYear).orElse(0));
        return (int)(Optional.ofNullable(this.getAccountCreationYear()).orElse(0).compareTo(Optional.ofNullable(o.getAccountCreationYear()).orElse(0)));

    }
}
