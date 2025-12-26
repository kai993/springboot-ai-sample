package com.example.spring_boot_ai_sample.infrastructure.repository;

import com.example.spring_boot_ai_sample.domain.entity.User;
import com.example.spring_boot_ai_sample.domain.repository.UserRepository;
import com.example.spring_boot_ai_sample.domain.valueobject.UserId;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ユーザーリポジトリの実装
 * インフラストラクチャ層でデータアクセスの実装を提供
 * 本実装ではインメモリストレージを使用（実際の開発ではJPAなどを使用）
 */
@Repository
public class InMemoryUserRepository implements UserRepository {
    
    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;
    
    public InMemoryUserRepository() {
        // サンプルデータの初期化
        initializeSampleData();
    }
    
    private void initializeSampleData() {
        LocalDateTime now = LocalDateTime.now();
        
        User user1 = new User(
            new UserId(1L),
            "山田太郎",
            now.minusDays(30),
            now.minusDays(30)
        );
        
        User user2 = new User(
            new UserId(2L),
            "佐藤花子",
            now.minusDays(20),
            now.minusDays(10)
        );
        
        User user3 = new User(
            new UserId(3L),
            "田中次郎",
            now.minusDays(15),
            now.minusDays(5)
        );
        
        users.put(1L, user1);
        users.put(2L, user2);
        users.put(3L, user3);
        nextId = 4L;
    }
    
    @Override
    public Optional<User> findById(UserId userId) {
        return Optional.ofNullable(users.get(userId.getValue()));
    }
    
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    
    @Override
    public List<User> findByNameContaining(String name) {
        return users.values().stream()
            .filter(user -> user.getName().contains(name))
            .collect(Collectors.toList());
    }
    
    @Override
    public User save(User user) {
        if (user.getUserId().getValue() == null) {
            // 新規作成の場合
            UserId newUserId = new UserId(nextId++);
            User newUser = new User(
                newUserId,
                user.getName(),
                user.getCreatedAt() != null ? user.getCreatedAt() : LocalDateTime.now(),
                LocalDateTime.now()
            );
            users.put(newUserId.getValue(), newUser);
            return newUser;
        } else {
            // 更新の場合
            users.put(user.getUserId().getValue(), user);
            return user;
        }
    }
    
    @Override
    public void deleteById(UserId userId) {
        users.remove(userId.getValue());
    }
}
