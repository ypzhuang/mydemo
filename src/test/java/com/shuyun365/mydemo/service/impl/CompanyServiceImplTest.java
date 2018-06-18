package com.shuyun365.mydemo.service.impl;

import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.repo.CompanyRepository;
import com.shuyun365.mydemo.service.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CompanyServiceImplTest {
    @TestConfiguration
    static class CompanyServiceImplTestContextConfiguration {
        @Bean
        public CompanyService companyService() {
            return new CompanyServiceImpl();
        }
    }

    @Autowired
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;


    @Before
    public void setUp() {
        Company company = new Company("数赟科技公司");
        Mockito.when(companyRepository.findByCompanyNameContaining("数赟"))
                .thenReturn(Arrays.asList(company));
    }


    @Test
    public void whenValidName_thenCompanyShouldBeFound() {
        String name = "数赟";
        List<Company> found = companyService.findByName(name);
        assertThat(found.size()).isEqualTo(1);

        assertThat(found.get(0).getCompanyName())
                .isEqualTo("数赟科技公司");
    }
}
