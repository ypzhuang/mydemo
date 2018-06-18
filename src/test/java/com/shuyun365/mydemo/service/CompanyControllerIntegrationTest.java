package com.shuyun365.mydemo.service;

import com.shuyun365.mydemo.MydemoApplication;
import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.repo.CompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MydemoApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.yml")
public class CompanyControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CompanyRepository repository;


    @Test
    public void givenCompanies_whenGetCompanies_thenReturnJsonArray() throws Exception {
        final String companyName = "数赟";
        createTestCompany(companyName);
        mvc.perform(get("/api/companies?name=" + companyName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].companyName", is(companyName)));
    }

    private void createTestCompany(String companyName) {
        Company alex = new Company(companyName);
        repository.save(alex);
        repository.flush();
    }
}
