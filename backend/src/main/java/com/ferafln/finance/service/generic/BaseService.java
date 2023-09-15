package com.ferafln.finance.service.generic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService {

    <T extends JpaRepository> T getRepository();

}
