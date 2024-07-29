package likelion.eight.db.bootcamp;

import jakarta.persistence.*;
import likelion.eight.db.review.ReviewEntity;
import likelion.eight.db.userBootcamp.UserBootcampEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bootcamps")
@Getter @Setter
public class BootcampEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bootcamp_id")
    private Long id;

    private String name;
    private String logo;
    private String description;
    private String location;
    private boolean onlineOffline;
    private Double averageRating;

    @OneToMany(mappedBy = "bootcampEntity", cascade = CascadeType.ALL)
    private List<UserBootcampEntity> userBootcampEntities = new ArrayList<>();

    @OneToMany(mappedBy = "bootcampEntity", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntities = new ArrayList<>();
}
