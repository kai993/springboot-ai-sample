package com.example.spring_boot_ai_sample.application.service;

import com.example.spring_boot_ai_sample.domain.entity.User;
import com.example.spring_boot_ai_sample.domain.repository.UserRepository;
import com.example.spring_boot_ai_sample.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザーアプリケーションサービス
 * ユースケースを実装し、ドメイン層とプレゼンテーション層を仲介
 */
@Service
@RequiredArgsConstructor
public class UserApplicationService {
    
    private final UserRepository userRepository;
    
    /**
     * ユーザーIDでユーザーを取得する
     * @param userId ユーザーID
     * @return ユーザーエンティティ
     * @throws IllegalArgumentException ユーザーが見つからない場合
     */
    public User getUserById(Long userId) {
        UserId id = new UserId(userId);
        return userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ユーザーが見つかりません: " + userId));
    }
    
    /**
     * 全てのユーザーを取得する
     * @return ユーザーリスト
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * 名前でユーザーを検索する
     * @param name 検索する名前
     * @return マッチするユーザーリスト
     */
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }
    
    /**
     * ユーザー存在チェック
     * @param userId ユーザーID
     * @return 存在する場合true
     */
    public boolean existsUserById(Long userId) {
        UserId id = new UserId(userId);
        return userRepository.findById(id).isPresent();
    }
}
