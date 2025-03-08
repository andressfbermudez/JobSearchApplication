package com.jobsearch.core;

import com.jobsearch.api.Job;
import java.util.List;

public class Filter {

    public List<Job> usaJobs(List<Job> jobs) {
        return jobs.stream()
                .filter(location -> location.candidateRequiredLocation().equals("USA"))
                .toList();
    }

    public List<Job> europeJobs(List<Job> jobs) {
        return jobs.stream()
                .filter(location -> location.candidateRequiredLocation().equals("Europe"))
                .toList();
    }

    public List<Job> southAmericaJobs(List<Job> jobs) {
        return jobs.stream()
                .filter(location -> location.candidateRequiredLocation().equals("South America"))
                .toList();
    }
}
