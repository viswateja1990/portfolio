package com.viswateja.portfolio.configuration;

import com.viswateja.portfolio.entity.*;
import com.viswateja.portfolio.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataConfiguration {

    @Bean
    public CommandLineRunner loadAllData(
            IntroductionRepository introRepo,
            LocationRepository locationRepo,
            RoleRepository roleRepo,
            DegreeRepository degreeRepo,
            EmployerRepository employerRepo,
            ProjectRepository projectRepo
    ) {
        return args -> {
            // Load introductions
            introRepo.save(new Introduction(1L, "Experienced Java and J2EE developer with over 11 years of professional experience in requirements analysis, performance analysis, design, development, and implementation of client-server technologies."));
            introRepo.save(new Introduction(2L, "Currently working as a Senior Software Engineer at Wells Fargo."));
            introRepo.save(new Introduction(3L, "Oracle Certified Professional, Java SE 6 Programmer."));

            // Load locations
            locationRepo.save(new Location(1L, "Hyderabad", "Telangana", "India"));
            locationRepo.save(new Location(2L, "New York City", "New York", "United States"));
            locationRepo.save(new Location(3L, "Piscataway", "New Jersey", "United States"));
            locationRepo.save(new Location(4L, "Maryland Heights", "Missouri", "United States"));
            locationRepo.save(new Location(5L, "Charlotte", "North Carolina", "United States"));
            locationRepo.save(new Location(6L, "San Diego", "California", "United States"));
            locationRepo.save(new Location(7L, "Frisco", "Texas", "United States"));

            Location location1 = locationRepo.findById(1L).orElseThrow();
            Location location2 = locationRepo.findById(2L).orElseThrow();
            Location location3 = locationRepo.findById(3L).orElseThrow();
            Location location4 = locationRepo.findById(4L).orElseThrow();
            Location location5 = locationRepo.findById(5L).orElseThrow();
            Location location6 = locationRepo.findById(6L).orElseThrow();
            Location location7 = locationRepo.findById(7L).orElseThrow();

            // Load roles
            roleRepo.save(new Role(1L, "Senior Software Developer"));
            roleRepo.save(new Role(2L, "Lead Application Developer"));
            roleRepo.save(new Role(3L, "Software Developer"));
            roleRepo.save(new Role(4L, "Programmer Analyst"));

            Role role1 = roleRepo.findById(1L).orElseThrow();
            Role role2 = roleRepo.findById(2L).orElseThrow();
            Role role3 = roleRepo.findById(3L).orElseThrow();
            Role role4 = roleRepo.findById(4L).orElseThrow();

            // Load degrees
            degreeRepo.save(new Degree(1L, "Master of Science in Computer Science", "National University", LocalDate.of(2014, 8, 15), LocalDate.of(2016, 3, 22), location6));
            degreeRepo.save(new Degree(2L, "Bachelor of Technology in Electronics and Communications Engineering", "Jawaharlal Nehru Technological University", LocalDate.of(2008, 9, 23), LocalDate.of(2012, 5, 5), location1));


            // Load projects
            projectRepo.save(new Project(1L, "IHub Technologies", LocalDate.of(2012, 5, 12), LocalDate.of(2014, 8, 2), "", location1));
            projectRepo.save(new Project(2L, "Barclays", LocalDate.of(2016, 7, 13), LocalDate.of(2017, 12, 23), "", location2));
            projectRepo.save(new Project(3L, "Goldman Sachs", LocalDate.of(2018, 1, 6), LocalDate.of(2018, 7, 25), "", location2));
            projectRepo.save(new Project(4L, "Charter Communications Inc", LocalDate.of(2018, 7, 25), LocalDate.of(2019, 4, 30), "", location4));
            projectRepo.save(new Project(5L, "Charter Communications Inc", LocalDate.of(2019, 5, 1), LocalDate.of(2019, 8, 9), "", location4));
            projectRepo.save(new Project(6L, "Charter Communications Inc", LocalDate.of(2019, 8, 12), LocalDate.of(2022, 6, 12), "", location4));
            projectRepo.save(new Project(7L, "Charter Communications Inc", LocalDate.of(2022, 6, 13), LocalDate.of(2023, 6, 30), "", location4));
            projectRepo.save(new Project(8L, "Wells Fargo", LocalDate.of(2023, 7, 14), null, "", location5));

            Project project1 = projectRepo.findById(1L).orElseThrow();
            Project project2 = projectRepo.findById(2L).orElseThrow();
            Project project3 = projectRepo.findById(3L).orElseThrow();
            Project project4 = projectRepo.findById(4L).orElseThrow();
            Project project5 = projectRepo.findById(5L).orElseThrow();
            Project project6 = projectRepo.findById(6L).orElseThrow();
            Project project7 = projectRepo.findById(7L).orElseThrow();
            Project project8 = projectRepo.findById(8L).orElseThrow();

            // Load employers
            employerRepo.save(new Employer(1L, "IHub Technologies", LocalDate.of(2012, 5, 12), LocalDate.of(2014, 8, 2), location1, role3, List.of(project1)));
            employerRepo.save(new Employer(2L, "Mpower Logic Inc", LocalDate.of(2016, 7, 13), LocalDate.of(2019, 8, 9), location3, role4, Arrays.asList(project2, project3, project4, project5)));
            employerRepo.save(new Employer(3L, "Amoris IT Inc", LocalDate.of(2019, 8, 12), LocalDate.of(2022, 6, 12), location7, role3, List.of(project6)));
            employerRepo.save(new Employer(4L, "Charter Communications Inc", LocalDate.of(2022, 6, 13), LocalDate.of(2023, 6, 30), location4, role2, List.of(project7)));
            employerRepo.save(new Employer(5L, "Experis US LLC", LocalDate.of(2023, 7, 14), null, location5, role1, List.of(project8)));


        };
    }
}