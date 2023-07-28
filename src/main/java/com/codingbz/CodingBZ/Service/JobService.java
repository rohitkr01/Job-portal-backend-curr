package com.codingbz.CodingBZ.Service;

import com.codingbz.CodingBZ.DTOs.JobDTO;
import com.codingbz.CodingBZ.Model.Job;
import com.codingbz.CodingBZ.Model.JobApplication;
import com.codingbz.CodingBZ.Model.User;
import com.codingbz.CodingBZ.Repository.JobApplicationRepository;
import com.codingbz.CodingBZ.Repository.JobRepository;
import com.codingbz.CodingBZ.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    JobRepository jobRepository;

    UserRepository userRepository;
    JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobService(JobRepository jobRepository,UserRepository userRepository,JobApplicationRepository jobApplicationRepository){
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }


    public void createJob(Job job) {
        jobRepository.save(job);
    }

    public Job updateJob(JobDTO updatedJob){
        Long jobId = updatedJob.getId();
        Job existingJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found with ID: " + jobId));

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobRole(updatedJob.getJobRole());
        existingJob.setJobDescription(updatedJob.getJobDescription());
        existingJob.setLocation(updatedJob.getLocation());

        existingJob.setSkills(updatedJob.getSkills());
        existingJob.setVacancies(updatedJob.getVacancies());
        existingJob.setSalary(updatedJob.getSalary());
        jobRepository.save(existingJob);

        return jobRepository.save(existingJob);
    }

    public Job getJobById(Long id){
        List<Job> jobList = jobRepository.findAll().stream()
                .filter(job -> ( job.getId().equals(id))).collect(Collectors.toList());
        Job job = jobList.get(0);

        return job;
    }

    public List<Job> getAllJob(){
        List<Job> jobs = jobRepository.findAll();
        return jobs;
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    public void applyForJob(Long user_id, Long job_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Job job = jobRepository.findById(job_id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        JobApplication jobApplication = new JobApplication();
        jobApplication.setUser(user);
        jobApplication.setJob(job);

        jobApplicationRepository.save(jobApplication);
    }

}
