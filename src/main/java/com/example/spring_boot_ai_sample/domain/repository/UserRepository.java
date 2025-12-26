package com.example.spring_boot_ai_sample.domain.repository;

import com.example.spring_boot_ai_sample.domain.entity.User;
import com.example.spring_boot_ai_sample.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;

/**
 * ユーザーリポジトリインターフェース
 * ドメイン層でデータアクセスの契約を定義
 */
public interface UserRepository {
    
    /**
     * ユーザーIDでユーザーを取得する
     * @param userId ユーザーID
     * @return ユーザーエンティティ（存在しない場合はEmpty）
     */
    Optional<User> findById(UserId userId);
    
    /**
     * 全てのユーザーを取得する
     * @return ユーザーリスト
     */
    List<User> findAll();
    
    /**
     * 名前でユーザーを検索する（部分一致）
     * @param name 検索する名前
     * @return マッチするユーザーリスト
     */
    List<User> findByNameContaining(String name);
    
    /**
     * ユーザーを保存する
     * @param user ユーザーエンティティ
     * @return 保存されたユーザーエンティティ
     */
    User save(User user);
    
    /**
     * ユーザーを削除する
     * @param userId ユーザーID
     */
    void deleteById(UserId userId);
}
