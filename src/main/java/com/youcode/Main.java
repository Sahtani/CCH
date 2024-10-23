package com.youcode;

import com.youcode.config.AppConfig;
import com.youcode.dtos.request.CompetitionRequestDTO;
import com.youcode.dtos.request.GeneralResultRequestDTO;
import com.youcode.dtos.request.TeamRequestDTO;
import com.youcode.dtos.response.CompetitionResponseDto;
import com.youcode.dtos.response.GeneralResultResponseDTO;
import com.youcode.dtos.response.TeamResponseDTO;
import com.youcode.services.api.CompetitionService;
import com.youcode.services.api.GeneralResultService;
import com.youcode.services.api.TeamService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //  save Cyclist :
//        CyclistService cyclistService = context.getBean(CyclistService.class);
//        TeamService teamService = context.getBean(TeamService.class);
//
//        CyclistRequestDTO newCyclistDTO = new CyclistRequestDTO("ayoub snini", 20,       // Age
//                "American",
//                1L
//        );
//        Optional<TeamResponseDTO> teamResponse = teamService.getById(1L);
//
//        if (teamResponse.isEmpty()) {
//            throw new IllegalArgumentException("Team not found with ID: 1");
//        }
//        CyclistResponseDTO savedCyclist = cyclistService.save(newCyclistDTO);
//
//        System.out.println("New cyclist created: " + savedCyclist);


        //  save team
        TeamService teamService = context.getBean(TeamService.class);
        TeamRequestDTO newTeamDTO = new TeamRequestDTO("Team 2");
        TeamResponseDTO savedTeam = teamService.save(newTeamDTO);

        System.out.println("Team saved: " + savedTeam.name());

     //   CompetitionService competitionService = context.getBean(CompetitionService.class);
////
//// Create a new CompetitionRequestDTO
//        CompetitionRequestDTO competitionDTO = new CompetitionRequestDTO(
//                "Tour de France",
//                "France",
//                2024,
//                LocalDate.of(2024, 7, 1),
//                LocalDate.of(2024, 7, 23)
//        );
//
//
//        CompetitionResponseDto savedCompetition = competitionService.save(competitionDTO);
//
//        System.out.println("Competition inserted with ID: " + savedCompetition.id());
//

        GeneralResultService generalResultService = context.getBean(GeneralResultService.class);

        Long cyclistId = 1L;
        Long competitionId = 1L;

        GeneralResultRequestDTO dto = new GeneralResultRequestDTO(competitionId, cyclistId);

        try {
            GeneralResultResponseDTO result = generalResultService.subscribeToCompetition(dto);
            System.out.println("Cyclist registered successfully in the competition.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
//

    }}
