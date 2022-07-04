package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.FeedbackRepository;
import com.register.OrthodoxProject.TableInfo.Cafe;
import com.register.OrthodoxProject.TableInfo.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

private final FeedbackRepository feedbackRepository;
@Autowired
    public FeedbackService(FeedbackRepository feedbackRepository){this.feedbackRepository=feedbackRepository;}
    public List<Feedback> getFeedback(){return feedbackRepository.findAll();}
    public void addNewFeedback(Feedback feedback){
    feedbackRepository.save(feedback);
    }
    public void updateFeedback(Long id, Cafe cafe_id, String feedback, Integer score){
    Feedback feedBack = feedbackRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException("Feedback with id: "+id+" does not exists"));
    if (cafe_id!=null && feedBack.getCafe()!=cafe_id){
        feedBack.setCafe(cafe_id);
    }
    if (feedback!=null && feedBack.getFeedback()!=feedback){
        feedBack.setFeedback(feedback);
    }
    if (score!=null && feedBack.getScore()!=score){
        feedBack.setScore(score);
    }
    }

    public void deleteFeedback(Long id) {
    boolean exists = feedbackRepository.existsById(id);
    if (!exists){
        throw new IllegalStateException("Feedback with id: "+id+" does not exists");
    }else{
        feedbackRepository.deleteById(id);
        System.out.println("Feedback with id: "+id+" was delete");
        }
    }
}
