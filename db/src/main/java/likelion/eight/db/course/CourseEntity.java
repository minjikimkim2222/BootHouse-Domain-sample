package likelion.eight.db.course;

import jakarta.persistence.*;
import likelion.eight.db.bootcamp.BootcampEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
public class CourseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;

    private String name;              // 코스 이름
    private int duration;             // 코스 기간 (일 수)
    private String description;       // 코스 설명
}
