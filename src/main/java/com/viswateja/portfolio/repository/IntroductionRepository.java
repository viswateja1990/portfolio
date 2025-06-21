package com.viswateja.portfolio.repository;

import com.viswateja.portfolio.entity.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntroductionRepository extends JpaRepository<Introduction, Long> {
}