package com.youcode.runners;

import com.youcode.entities.Cyclist;
import com.youcode.services.api.CyclistService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.youcode.config.HibernateConfig;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);


        CyclistService cyclistService = context.getBean(CyclistService.class);


        Cyclist newCyclist = new Cyclist();
        newCyclist.setFirstName("soumia");
        newCyclist.setLastName("Doe");
        newCyclist.setAge(15);
        newCyclist.setNationality("American");


        Cyclist savedCyclist = cyclistService.save(newCyclist);


        System.out.println("New cyclist created: " + savedCyclist);


        ((AnnotationConfigApplicationContext) context).close();
    }
}
