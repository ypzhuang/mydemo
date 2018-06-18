package com.shuyun365.mydemo.repo;

import com.shuyun365.mydemo.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {
    List<Company> findByCompanyNameContaining(String companName);
}
