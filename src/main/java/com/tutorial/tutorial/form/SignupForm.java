package com.tutorial.tutorial.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * ユーザー登録画面Form
 * 
 * @author shimokawa
 * 
 */
@Data
public class SignupForm {
  /** ログインID */
  @Length(min = 8, max = 20)
  private String loginId;
  /** パスワード */
  @Length(min = 8, max = 20)
  private String password;
}
