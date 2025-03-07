package com.jobsearch.api;

import com.google.gson.annotations.SerializedName;

public record Job(

        String id,
        String url,
        String title,

        @SerializedName("company_name")
        String companyName,

        @SerializedName("company_logo")
        String companyLogo,

        String category,

        @SerializedName("job_type")
        String jobType,

        @SerializedName("publication_date")
        String publicationDate,

        @SerializedName("candidate_required_location")
        String candidateRequiredLocation,

        String salary,
        String description
) {
    @Override
    public String toString() {
        return "\nId: " + id +
                "\nUrl: " + url +
                "\nTitle: " + title +
                "\nCompany Name: " + companyName +
                "\nCompany Logo: " + companyLogo +
                "\nCategory: " + category +
                "\nJob Type: " + jobType +
                "\nPublication Date: " + publicationDate +
                "\nCandidate Required Location: " + candidateRequiredLocation +
                "\nSalary: " + salary +
                "\nDescription: " + description;
    }
}
