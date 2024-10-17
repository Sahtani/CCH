package com.youcode.runners;

import com.youcode.entities.Cyclist;
import com.youcode.services.interfaces.CyclistService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.youcode.config.HibernateConfig;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);


        CyclistService cyclistService = context.getBean(CyclistService.class);


        Cyclist newCyclist = new Cyclist();
        newCyclist.setFirstName("John");
        newCyclist.setLastName("Doe");
        newCyclist.setDateBirth(LocalDate.of(1990, 5, 15));
        newCyclist.setNationality("American");


        Cyclist savedCyclist = cyclistService.saveCyclist(newCyclist);


        System.out.println("New cyclist created: " + savedCyclist);


        ((AnnotationConfigApplicationContext) context).close();
    }
}
