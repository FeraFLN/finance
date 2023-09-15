package com.ferafln.finance.repository;

import com.ferafln.finance.model.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial, Integer> {

}
