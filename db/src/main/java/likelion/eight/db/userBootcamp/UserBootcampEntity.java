package likelion.eight.db.userBootcamp;

import jakarta.persistence.*;
import likelion.eight.db.bootcamp.BootcampEntity;
import likelion.eight.db.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_bootcamps")
@Getter @Setter
public class UserBootcampEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_bootcamp_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;

    @Enumerated(EnumType.STRING)
    private UserBootcampStatus status; // 관심,수강중,수료

    private String verificationFile; // 인증 파일 URL

    // == 연관관계 메서드 == -> 양방향 매핑
    public void setUser(UserEntity userEntity){
        this.userEntity = userEntity;
        userEntity.getUserBootcampEntities().add(this);
    }

    public void setBootcamp(BootcampEntity bootcampEntity){
        this.bootcampEntity = bootcampEntity;
        bootcampEntity.getUserBootcampEntities().add(this);
    }


}
