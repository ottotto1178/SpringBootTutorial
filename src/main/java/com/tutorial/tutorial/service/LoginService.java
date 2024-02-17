package com.tutorial.tutorial.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tutorial.tutorial.entity.UserInfo;
import com.tutorial.tutorial.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Service
 * 
 * @author shimokawa
 * 
 */
@Service
@RequiredArgsConstructor
public class LoginService {
  /** ユーザー情報テーブルDAO */
  private final UserInfoRepository repository;

  /**
   * ユーザー情報テーブルキー検索
   * 
   * @param loginId ログインID
   * @return 検索結果
   */
  @SuppressWarnings("null")
  public Optional<UserInfo> searchUserById(String loginId) {
    return repository.findById(loginId);
  }
}