package likelion.eight.db.admin;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import likelion.eight.db.notice.NoticeEntity;
import likelion.eight.db.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
@Getter @Setter
public class AdminEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "adminEntity", cascade = CascadeType.ALL)
    private List<NoticeEntity> noticeEntities = new ArrayList<>();

    // == 연관관계 메서드 == -> 양방향 관계만
    public void setUserEntity(UserEntity userEntity){
        this.userEntity = userEntity;
        userEntity.getAdminEntities().add(this);
    }

    public void setNoticeEntity(NoticeEntity noticeEntity){
        noticeEntity.setAdminEntity(this);
        noticeEntities.add(noticeEntity);
    }
}
