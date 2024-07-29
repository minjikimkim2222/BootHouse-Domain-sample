package likelion.eight.db.bootcampDetail;

import jakarta.persistence.*;
import likelion.eight.db.bootcamp.BootcampEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bootcampDetails")
@Getter @Setter
public class BootcampDetailEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bootcamp_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;

    private String instructor; // 강사정보
    private int trainingAllowance; // 훈련수당
    private boolean cardRequirement; // 내일배움카드 필수 여부


}
