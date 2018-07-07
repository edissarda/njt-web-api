/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import hibernate.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author edis
 */
@SpringBootApplication
@ComponentScan(basePackages = {"config", "controller", "service"})
public class App {

    public static void main(String[] args) {

        HibernateUtil.getInstance();
        SpringApplication.run(App.class, args);

    }
}
