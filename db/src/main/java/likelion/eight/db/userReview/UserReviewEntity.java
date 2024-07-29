package likelion.eight.db.userReview;

import jakarta.persistence.*;
import likelion.eight.db.review.ReviewEntity;
import likelion.eight.db.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userReviews")
@Getter @Setter
public class UserReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private ReviewEntity reviewEntity;

    // == 연관관계 메서드 ==
    public void setUserEntity(UserEntity userEntity){
        this.userEntity = userEntity;
        userEntity.getUserReviewEntities().add(this);
    }

    public void setReviewEntity(ReviewEntity reviewEntity){
        this.reviewEntity = reviewEntity;
        reviewEntity.getUserReviewEntities().add(this);
    }
}
