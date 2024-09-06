package com.learnspringboot.app.Job.impl;

import com.learnspringboot.app.Job.Job;
import com.learnspringboot.app.Job.JobRepository;
import com.learnspringboot.app.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {
    Long nextId=1L;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //  private  List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepository.save(job);

    }

    @Override
    public Job geJobById(Long id) {
//     for(Job j:jobs)
//     {
//         if(Objects.equals(j.getId(), id))
//             return j;
//
//     }
//        return null;
        //now using jpa repository
        return jobRepository.findById(id).orElse(null); // it return an optional so we us .or else
        //to make ti return null if nothing found with this id
    }

    @Override
    public boolean removeJobById(Long id) {
       try{
           jobRepository.deleteById(id);
           return true;
       } catch (Exception e){
           return false;
       }

    }

    @Override
    public boolean updateJobById(Long id, Job Updatedjob) {

        Optional<Job> jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Job job=jobOptional.get();
            job.setMaxSalary(Updatedjob.getMaxSalary());
            job.setTitle(Updatedjob.getTitle());
            job.setMinSalary(Updatedjob.getMinSalary());
            job.setDescription(Updatedjob.getDescription());
            jobRepository.save(job);
return  true;
        }
        return false;
    }


}
