package com.example.noodle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAnswers {
    @Id
    @SequenceGenerator(name = "Sanswers_sequence",
            sequenceName = "Sanswers_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sanswers_sequence")
    private Long id;

    @Column(name = "Answer1", nullable = false)
    private String answer1;

    @Column(name = "Answer2", nullable = false)
    private String answer2;

    @Column(name = "Answer3", nullable = false)
    private String answer3;

    @Column(name = "Answer4", nullable = true)
    private String answer4;

    @Column(name = "Answer5", nullable = true)
    private String answer5;

    @Column(name = "Answer6", nullable = true)
    private String answer6;

    @Column(name = "Answer7", nullable = true)
    private String answer7;

    @Column(name = "Answer8", nullable = true)
    private String answer8;

    @Column(name = "Answer9", nullable = true)
    private String answer9;

    @Column(name = "Answer10", nullable = true)
    private String answer10;

    @Column(name = "quizId", nullable = false)
    private int quizId;

    @Column(name = "studentId", nullable = false)
    private int studentId;

    @Override
    public String toString() {
        return "StudentAnswers{" +
                "id=" + id +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", answer5='" + answer5 + '\'' +
                ", answer6='" + answer6 + '\'' +
                ", answer7='" + answer7 + '\'' +
                ", answer8='" + answer8 + '\'' +
                ", answer9='" + answer9 + '\'' +
                ", answer10='" + answer10 + '\'' +
                ", quizId=" + quizId +
                ", studentId=" + studentId +
                '}';
    }
}
