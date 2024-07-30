package likelion.eight.db.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum UserRole {
    ROLE_USER("일반 사용자"),
    ROLE_ADMIN("관리자")
    ;

    private String description;
}
