package com.example.spring_boot_ai_sample.presentation.dto;

import com.example.spring_boot_ai_sample.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * ユーザーレスポンスDTO
 * プレゼンテーション層でのデータ転送オブジェクト
 */
@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    
    /**
     * ドメインエンティティからDTOに変換
     * @param user ユーザーエンティティ
     * @return ユーザーレスポンスDTO
     */
    public static UserResponseDto fromEntity(User user) {
        return new UserResponseDto(
            user.getUserId().getValue(),
            user.getName(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }
}
