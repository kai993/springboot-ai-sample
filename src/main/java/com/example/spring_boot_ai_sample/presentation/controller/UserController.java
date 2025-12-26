package com.example.spring_boot_ai_sample.presentation.controller;

import com.example.spring_boot_ai_sample.application.service.UserApplicationService;
import com.example.spring_boot_ai_sample.domain.entity.User;
import com.example.spring_boot_ai_sample.presentation.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ユーザーコントローラー
 * ユーザー情報取得に関するエンドポイントを提供
 * RESTful APIの設計に従い、適切なHTTPメソッドとステータスコードを使用
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserApplicationService userApplicationService;
    
    /**
     * 全てのユーザーを取得
     * GET /api/users
     * @return ユーザーリスト
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userApplicationService.getAllUsers();
        List<UserResponseDto> response = users.stream()
            .map(UserResponseDto::fromEntity)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * ユーザーIDで単一ユーザーを取得
     * GET /api/users/{userId}
     * @param userId ユーザーID
     * @return ユーザー情報
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        try {
            User user = userApplicationService.getUserById(userId);
            UserResponseDto response = UserResponseDto.fromEntity(user);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 名前でユーザーを検索
     * GET /api/users/search?name={name}
     * @param name 検索する名前
     * @return マッチするユーザーリスト
     */
    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDto>> searchUsersByName(@RequestParam String name) {
        List<User> users = userApplicationService.searchUsersByName(name);
        List<UserResponseDto> response = users.stream()
            .map(UserResponseDto::fromEntity)
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * ユーザーの存在確認
     * HEAD /api/users/{userId}
     * @param userId ユーザーID
     * @return 存在する場合200、存在しない場合404
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> checkUserExists(@PathVariable Long userId) {
        boolean exists = userApplicationService.existsUserById(userId);
        return exists ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
