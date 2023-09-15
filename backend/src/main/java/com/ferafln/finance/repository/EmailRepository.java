package com.ferafln.finance.repository;

import com.ferafln.finance.model.EmailSend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailSend,Long> {
}
