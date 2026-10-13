package com.SD.Spring_AOP.service;

import com.SD.Spring_AOP.Model.JobPost;
import com.SD.Spring_AOP.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepo repo;
    public List<JobPost> getAllJobs() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }
    public JobPost getById(int postId) {
        // TODO Auto-generated method stub
        //System.out.println(2/0);
        return repo.findById(postId).orElse(new JobPost());
    }
    public void delete(int postId) {
        // TODO Auto-generated method stub
        repo.deleteById(postId);
    }
    public void Add(JobPost jobpost) {
        // TODO Auto-generated method stub
        repo.save(jobpost);
    }
    public void update(JobPost jobpost) {
        // TODO Auto-generated method stub
        repo.save(jobpost);

    }
    public List<JobPost> search(String keyword) {
        // TODO Auto-generated method stub
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
