package likelion.eight.db.chatlist;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import likelion.eight.db.chat.ChatEntity;
import likelion.eight.db.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "chat_lists")
@Getter @Setter
public class ChatListEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_list_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_chat_id")
    private ChatEntity lastChat; // 마지막 채팅메세지
}
