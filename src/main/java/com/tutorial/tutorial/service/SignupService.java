package com.tutorial.tutorial.service;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutorial.tutorial.entity.UserInfo;
import com.tutorial.tutorial.form.SignupForm;
import com.tutorial.tutorial.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面Service
 * 
 * @author shimokawa
 * 
 */
@Service
@RequiredArgsConstructor
public class SignupService {
  /** ユーザー情報テーブルDAO */
  private final UserInfoRepository repository;

  /** Dozer Mapper */
  private final Mapper mapper;

  /** PasswordEncorder */
  private final PasswordEncoder passwordEncoder;

  /**
   * ユーザー情報テーブル新規登録
   * 
   * @param form 入力情報
   * @return 登録情報(ユーザー情報Entity)、既にIDが登録されている場合はEmpty
   */
  @SuppressWarnings("null")
  public Optional<UserInfo> registerUserInfo(SignupForm form) {
    var userInfoExistedOpt = repository.findById(form.getLoginId());

    if (userInfoExistedOpt.isPresent()) {
      return Optional.empty();
    }
    var userInfo = mapper.map(form, UserInfo.class);
    var encodedPassword = passwordEncoder.encode(form.getPassword());
    userInfo.setPassword(encodedPassword);
    return Optional.of(repository.save(userInfo));
  }
}