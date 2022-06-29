package com.register.OrthodoxProject.Repository;

import com.register.OrthodoxProject.TableInfo.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository
    extends JpaRepository<Feedback, Integer> {
}
