package likelion.eight.db.courseCategory;

import jakarta.persistence.*;
import likelion.eight.db.category.CategoryEntity;
import likelion.eight.db.course.CourseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CourseCategories")
@Getter @Setter
public class CourseCategoryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}
