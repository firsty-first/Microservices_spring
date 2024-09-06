package com.learnspringboot.app.Job;

import com.learnspringboot.app.Job.impl.JobServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {
    //here we create object of the interface type and call those methoods when neede for differrent mapping
    //this way we achieve loose coupling
   // JobService jobService;// this job service is not initialzed with any object
    //this is where we see magic of spring boot
    //so basically we annotate classs whose object is to be createde here with service so spring boot itslef create object of that class at compile time
    private final JobService jobService;

    // Constructor injection
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    private  List<Job> jobs=new ArrayList<>();
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll()
    {
        return  ResponseEntity.ok(jobService.findAll());
    }
    @PostMapping("/jobs")
    public  ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);
        return new ResponseEntity<>("Job successfully create",HttpStatus.CREATED);
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getById(@PathVariable Long id)  //when we pass data through url then it is called path variable
    {
        System.out.println(id);
        //other wise through body then @RequestBody
     Job job= jobService.geJobById(id);
     if(job!=null)
         return new ResponseEntity<>(job, HttpStatus.OK);
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    ResponseEntity<String> removeJobById(@PathVariable Long id)
    {

            boolean p= jobService.removeJobById(id);
            if(p)
                return new ResponseEntity<>("successfully remove ",HttpStatus.OK);
            else
                return new ResponseEntity<>("job with this id do not exist",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    ResponseEntity<String> updateJobById(@PathVariable Long id , @RequestBody Job job)
    {

        boolean p= jobService.updateJobById(id,job);
        if(p)
            return new ResponseEntity<>("successfully updated ",HttpStatus.OK);
        else
            return new ResponseEntity<>("job with this id does not exist",HttpStatus.NOT_FOUND);
    }
}
