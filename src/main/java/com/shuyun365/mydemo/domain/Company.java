package com.shuyun365.mydemo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_company")
@Data
@EqualsAndHashCode(callSuper=false)

public class Company extends BaseEntity {
    private static final long serialVersionUID = 1L;

    public Company(){}

    public Company(String companyName) {
        this.companyName = companyName;
    }

    @Column
    private String companyCode; //自动生成的公司ID：CO00001

    @Column
    private String companyName;

    @Column
    private String companyAddress;

    @Column
    private String companyProvince;

    @Column
    private String companyCity;

    @Column
    private String industryType;

    @Column
    private String industry;

    @Column
    private String orgSize;

    @Column
    private Boolean status;
}
