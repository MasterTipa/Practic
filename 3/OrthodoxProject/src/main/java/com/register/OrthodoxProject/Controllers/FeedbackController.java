package com.register.OrthodoxProject.Controllers;

import com.register.OrthodoxProject.Services.FeedbackService;
import com.register.OrthodoxProject.TableInfo.Cafe;
import com.register.OrthodoxProject.TableInfo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    @Autowired
    public FeedbackController(FeedbackService feedbackService){this.feedbackService=feedbackService;}
    @GetMapping
    public List<Feedback> getFeedback(){return feedbackService.getFeedback();}
    @PostMapping
    public void registerNewFeedback(@RequestBody Feedback feedback){feedbackService.addNewFeedback(feedback);}
    @DeleteMapping(path = "{id}")
    public void deleteFeedback(
            @PathVariable("id") Long id){
        feedbackService.deleteFeedback(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateFeedback(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Cafe cafe_id,
            @RequestParam(required = false) String feedback,
            @RequestParam(required = false) Integer score){
        feedbackService.updateFeedback(id,cafe_id,feedback,score);
    }
}
