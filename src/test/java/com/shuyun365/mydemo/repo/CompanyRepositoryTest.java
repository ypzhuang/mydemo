package com.shuyun365.mydemo.repo;


import com.shuyun365.mydemo.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class CompanyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void whenFindByName_thenReturnCompany() {
        // given
        Company company = new Company("数赟科技公司");
        entityManager.persist(company);
        entityManager.flush();

        String condition = company.getCompanyName().substring(0,2);

        // when
        List<Company> found = companyRepository.findByCompanyNameContaining(condition);

        // then
        assertThat(found)
                .isEqualTo(Arrays.asList(company));
    }
}
