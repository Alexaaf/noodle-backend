package com.example.noodle.repo;

import com.example.noodle.model.StudentAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAnswersRepository extends JpaRepository<StudentAnswers, Long > {
    @Query("SELECT e FROM StudentAnswers e WHERE e.quizId = :id")
    public List<StudentAnswers> findAnswersById(@Param("id") long id);
    @Override
    StudentAnswers save (StudentAnswers answers);

}
