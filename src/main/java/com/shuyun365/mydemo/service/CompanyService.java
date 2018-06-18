package com.shuyun365.mydemo.service;

import com.shuyun365.mydemo.domain.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findByName(String companyName);

    Company saveCompany(Company company);
}
