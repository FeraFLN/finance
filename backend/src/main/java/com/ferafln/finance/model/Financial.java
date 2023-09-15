package com.ferafln.finance.model;

import com.ferafln.finance.enums.FinancialEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Financial extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private FinancialGroup group;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FinancialEnum type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(nullable = false)
    private String name;

    private String description;
}

