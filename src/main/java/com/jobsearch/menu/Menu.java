package com.jobsearch.menu;

import com.jobsearch.api.Job;
import com.jobsearch.api.JobSearchRequest;
import com.jobsearch.core.Filter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void viewMenu() {
        List<Job> jobs = JobSearchRequest.search();
        if (jobs.isEmpty()) {
            throw new RuntimeException("The jobs list is empty");
        }

        while(true) {
            String menu = """
                    \n::::::::: Welcome to Job Search :::::::::
                          1. Filter jobs USA.
                          2. Filter jobs Europe.
                          3. Filter jobs South America.
                          0. Exit.
                    """;
            System.out.print(menu + "Enter your option: ");

            Scanner sc = new Scanner(System.in);
            Filter filter = new Filter();
            int optionUser = -1;

            try {
                optionUser = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            switch (optionUser) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    List<Job> usaJobs = filter.usaJobs(jobs);
                    usaJobs.forEach(System.out::println);
                    break;
                case 2:
                    List<Job> europeJobs = filter.europeJobs(jobs);
                    europeJobs.forEach(System.out::println);
                    break;
                case 3:
                    List<Job> southAmericaJobs = filter.southAmericaJobs(jobs);
                    southAmericaJobs.forEach(System.out::println);
                    break;
                default:
                    System.out.println("The jobs is empty");
            }
        }
    }
}
