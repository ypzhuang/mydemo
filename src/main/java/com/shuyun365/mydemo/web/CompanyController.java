package com.shuyun365.mydemo.web;

import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/companies")
@Slf4j
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> findCompaniesByName(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        log.debug("name:{}", companyService);
        return companyService.findByName(name);
    }
}
