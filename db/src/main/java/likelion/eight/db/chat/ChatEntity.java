package likelion.eight.db.chat;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import likelion.eight.db.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chats")
@Getter @Setter
public class ChatEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    private String content;
    private LocalDateTime sentAt = LocalDateTime.now(); // 요청생성시, 현재시간
    private LocalDateTime readAt; // 읽힌 시간, 기본값 null
}
