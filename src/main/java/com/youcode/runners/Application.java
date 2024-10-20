package com.youcode.runners;

import com.youcode.config.ServiceConfig;
import com.youcode.entities.Cyclist;
import com.youcode.entities.Team;
import com.youcode.services.api.CyclistService;
import com.youcode.services.api.TeamService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.youcode.config.AppConfig;

public class Application {
    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//      save Cyclist :
//
//        CyclistService cyclistService = context.getBean(CyclistService.class);
//        Cyclist newCyclist = new Cyclist();
//        newCyclist.setFirstName("soumia");
//        newCyclist.setLastName("Doe");
//        newCyclist.setAge(15);
//        newCyclist.setNationality("American");
//
//
//        Cyclist savedCyclist = cyclistService.save(newCyclist);
//
//
//        System.out.println("New cyclist created: " + savedCyclist);
//
//
//        ((AnnotationConfigApplicationContext) context).close();
        //save team
//        TeamService teamService = context.getBean(TeamService.class);
//        Team team = new Team();
//        team.setName("Team 3 ");
//        teamService.save(team);
//        System.out.println("Team saved");

    }
}
