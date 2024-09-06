package com.learnspringboot.app.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job,Long> { //<Entity class name , Datatypr of the id  >
// we do not need to hav eeimplementation of queries etc
}
