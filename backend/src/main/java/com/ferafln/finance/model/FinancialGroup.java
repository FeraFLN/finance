package com.ferafln.finance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Os grupos podem ser Redimentos, Gastos essenciais, planejados e nao planejados
 */
@Data
@Entity
@Table(name= "financial_group")
@NoArgsConstructor
public class FinancialGroup {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
