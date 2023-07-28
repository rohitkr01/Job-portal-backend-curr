package com.codingbz.CodingBZ.Repository;

import com.codingbz.CodingBZ.Model.JobApplication;
import com.codingbz.CodingBZ.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository  extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByUser(User user);
}
