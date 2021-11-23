package com.grzegorznowakowski.vps_tomcat_zdrofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class VpsTomcatZdrofitApplication {

    public static void main(String[] args) {
        SpringApplication.run(VpsTomcatZdrofitApplication.class, args);
    }

}
