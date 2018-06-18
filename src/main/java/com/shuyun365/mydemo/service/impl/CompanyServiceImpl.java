package com.shuyun365.mydemo.service.impl;

import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.repo.CompanyRepository;
import com.shuyun365.mydemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findByName(String companyName) {
        return companyRepository.findByCompanyNameContaining(companyName);
    }

    @Override
    @Transactional
    public Company saveCompany(Company company) {
        company.setId(null);
        return companyRepository.save(company);
    }
}
