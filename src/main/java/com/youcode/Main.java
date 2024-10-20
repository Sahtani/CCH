package com.youcode;

import com.youcode.config.AppConfig;
import com.youcode.entities.Competition;
import com.youcode.entities.GeneralResult;
import com.youcode.services.api.CompetitionService;
import com.youcode.services.api.GeneralResultService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //  save Cyclist :
//        CyclistService cyclistService = context.getBean(CyclistService.class);
//        Cyclist newCyclist = new Cyclist();
//        newCyclist.setFirstName("Soumia");
//        newCyclist.setLastName("Doe");
//        newCyclist.setAge(15);
//        newCyclist.setNationality("American");
//        TeamService teamService = context.getBean(TeamService.class);
//        Optional<Team> team = teamService.getById(1L);
//        newCyclist.setTeam(team.get());
//        cyclistService.save(newCyclist);
//        System.out.println("New cyclist created: " + newCyclist);


//
        //save team
//        TeamService teamService = context.getBean(TeamService.class);
//        Team team = new Team();
//        team.setName("Team 3 ");
//        teamService.save(team);
//        System.out.println("Team saved");
        //save competition ;
//        CompetitionService competitionService = context.getBean(CompetitionService.class);
//
//        // Create a new competition instance
//        Competition competition = new Competition();
//        competition.setName("Tour de France");
//        competition.setYear(2024);
//        competition.setLocation("France");
//        competition.setStartDate(LocalDate.of(2024, 7, 1));
//        competition.setEndDate(LocalDate.of(2024, 7, 23));
//        competition.setName("Giro d'Italia");
//        competition.setYear(2024);
//        competition.setLocation("Italy");
//        competition.setStartDate(LocalDate.of(2024, 5, 4));
//        competition.setEndDate(LocalDate.of(2024, 5, 26));
//        // Save the competition
//        Competition savedCompetition = competitionService.save(competition);
//
//        // Print confirmation
//        System.out.println("Competition inserted with ID: " + savedCompetition.getId());

        //inscription de cycliste dans competition
        GeneralResultService generalResultService = context.getBean(GeneralResultService.class);

        // Sample competition and cyclist IDs (replace these with valid IDs from your database)
        Long competitionId = 1L; // Replace with actual competition ID
        Long cyclistId = 2L;     // Replace with actual cyclist ID

        // Save the GeneralResult (register cyclist in competition)
        try {
            GeneralResult result = generalResultService.save(competitionId, cyclistId);
            System.out.println("Cyclist registered successfully in the competition.");
            System.out.println("Competition: " + result.getCompetition().getName());
            System.out.println("Cyclist: " + result.getCyclist().getName());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        ((AnnotationConfigApplicationContext) context).close();
    }
}
