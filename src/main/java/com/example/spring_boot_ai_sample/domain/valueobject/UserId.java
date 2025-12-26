package com.example.spring_boot_ai_sample.domain.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ユーザーIDバリューオブジェクト
 * 不変オブジェクトとしてユーザーの一意識別子を表現
 */
@Getter
@EqualsAndHashCode
public class UserId {
    private final Long value;

    public UserId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("ユーザーIDは正の値である必要があります");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserId{" + value + "}";
    }
}