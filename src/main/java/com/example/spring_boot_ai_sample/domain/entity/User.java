package com.example.spring_boot_ai_sample.domain.entity;

import com.example.spring_boot_ai_sample.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * ユーザーエンティティ
 * ドメイン層のコアエンティティとして、ユーザーの属性と振る舞いを定義
 */
@Getter
@AllArgsConstructor
public class User {
    private final UserId userId;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    /**
     * ユーザー情報を更新する
     * @param name 新しい名前
     * @return 更新されたユーザー
     */
    public User updateUserInfo(String name) {
        return new User(
            this.userId,
            name,
            this.createdAt,
            LocalDateTime.now()
        );
    }
}
