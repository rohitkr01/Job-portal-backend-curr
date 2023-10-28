package com.codingbz.CodingBZ.Repository;

import com.codingbz.CodingBZ.Model.JobApplication;
import com.codingbz.CodingBZ.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByUser(User user);
}
