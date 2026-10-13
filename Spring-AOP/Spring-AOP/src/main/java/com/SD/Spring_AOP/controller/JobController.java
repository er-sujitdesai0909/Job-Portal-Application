package com.SD.Spring_AOP.controller;

import com.SD.Spring_AOP.Model.JobPost;
import com.SD.Spring_AOP.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService service;
    @GetMapping("job")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
    @GetMapping("job/{id}")
    public JobPost getById(@PathVariable("id") int postId) {
        return service.getById(postId);
    }
    @DeleteMapping("job/{id}")
    public String delete(@PathVariable("id") int postId) {
        service.delete(postId);
        return "Deleted";
    }
    @PostMapping("job")
    public String Add(@RequestBody JobPost jobpost) {
        service.Add(jobpost);
        return "Added successfully";
    }
    @PutMapping("job")
    public JobPost update(@RequestBody JobPost jobpost) {
        service.update(jobpost);
        return jobpost;
    }
    @GetMapping("job/keyword/{keyword}")
    public List<JobPost> search(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
