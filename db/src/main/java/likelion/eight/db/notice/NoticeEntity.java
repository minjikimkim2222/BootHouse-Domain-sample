package likelion.eight.db.notice;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import likelion.eight.db.BaseEntity;
import likelion.eight.db.admin.AdminEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notices")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class NoticeEntity extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;

    private String title;
    private String content;
}
