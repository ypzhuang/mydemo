package com.shuyun365.mydemo.service;

import com.shuyun365.mydemo.domain.Company;
import com.shuyun365.mydemo.web.CompanyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CompanyService service;

    @Test
    public void givenCompanies_whenGetCompanies_thenReturnJsonArray() throws Exception {

        Company suxiang = new Company("甦翔");

        List<Company> allEmployees = Arrays.asList(suxiang);

        given(service.findByName(suxiang.getCompanyName())).willReturn(allEmployees);

        mvc.perform(get("/api/companies?name=甦翔")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].companyName", is(suxiang.getCompanyName())));
    }

}
