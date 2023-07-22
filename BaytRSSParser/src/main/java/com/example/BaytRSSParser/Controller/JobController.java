package com.example.BaytRSSParser.Controller;

import com.example.BaytRSSParser.Job;
import com.example.BaytRSSParser.Service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    ParserService parser;
//    @GetMapping("/jobs")
//    public String displayJobs(Model model) {
//        String rssUrl = "https://careers.moveoneinc.com/rss/all-rss.xml/";
//        List<String> jobTitles = parser.fetchJobTitlesFromRssFeed(rssUrl);
//        model.addAttribute("jobTitles", jobTitles);
//        return "job-list";
//    }

    @GetMapping("/jobs")
    public String displayJobs(Model model) {
        String rssUrl = "https://careers.moveoneinc.com/rss/all-rss.xml/";
        List<Job> jobs = parser.fetchJobsFromRssFeed(rssUrl);

        model.addAttribute("jobs", jobs);

        return "job-list";
    }
}

