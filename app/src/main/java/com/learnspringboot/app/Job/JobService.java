package com.learnspringboot.app.Job;

import java.util.List;

public interface JobService {
    //within job sercvice we will defince all the methods
    // which a class must implemetn
    //to provide loose couppling
    List<Job> findAll();
    void createJob(Job job);
    Job geJobById(Long id);
    boolean removeJobById(Long id);

    boolean updateJobById(Long id, Job job);
}
