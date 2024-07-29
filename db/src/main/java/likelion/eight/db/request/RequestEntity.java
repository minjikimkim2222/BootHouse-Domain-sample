package likelion.eight.db.request;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import likelion.eight.db.BaseEntity;
import likelion.eight.db.admin.AdminEntity;
import likelion.eight.db.user.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "requests")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class RequestEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;

    private String type; // 요청 유형

    @Enumerated(EnumType.STRING)
    private RequestStatus status; // 요청 상태
}
