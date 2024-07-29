package likelion.eight.db.review;

import jakarta.persistence.*;
import likelion.eight.db.BaseEntity;
import likelion.eight.db.bootcamp.BootcampEntity;
import likelion.eight.db.user.UserEntity;
import likelion.eight.db.userReview.UserReviewEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reviews")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class ReviewEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;

    private String title;
    private String content;
    private int rating;
    private int viewCount;

    @OneToMany(mappedBy = "reviewEntity", cascade = CascadeType.ALL)
    private List<UserReviewEntity> userReviewEntities = new ArrayList<>();

    // == 연관관계 메서드 ==
    public void setBootcampEntity(BootcampEntity bootcampEntity){
        bootcampEntity.getReviewEntities().add(this);
        this.bootcampEntity = bootcampEntity;
    }
}
