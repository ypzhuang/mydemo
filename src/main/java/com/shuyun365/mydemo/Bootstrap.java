package com.shuyun365.mydemo;

import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.repo.CompanyRepository;
import com.shuyun365.mydemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Bootstrap {
    @Autowired
    private Environment environment;

    @Autowired
    private CompanyService companyService;

    public boolean isDev() {
        return Arrays.stream(environment.getActiveProfiles()).anyMatch("dev"::equals);
    }

    @PostConstruct
    public void postConstruct() {
        if (isDev()) {
            Company comp = new Company("上海甦翔投资咨询有限公司");
            companyService.saveCompany(comp);
        }
    }
}
