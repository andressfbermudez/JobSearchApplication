package com.jobsearch;

import com.jobsearch.api.Job;
import com.jobsearch.api.JobSearchRequest;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Job> jobs = JobSearchRequest.submitSearch("front end");
        jobs.forEach(System.out::println);
    }
}
