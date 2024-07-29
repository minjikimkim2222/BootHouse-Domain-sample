package likelion.eight.db.user;

import jakarta.persistence.*;
import likelion.eight.db.admin.AdminEntity;
import likelion.eight.db.userBootcamp.UserBootcampEntity;
import likelion.eight.db.userReview.UserReviewEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private String nickname;
    private String email;
    private String password;
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private UserStatus status; // 사용자 상태

    @Enumerated(EnumType.STRING)
    private UserRole role; // 사용자 권한

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserBootcampEntity> userBootcampEntities = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserReviewEntity> userReviewEntities = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<AdminEntity> adminEntities = new ArrayList<>();

}
