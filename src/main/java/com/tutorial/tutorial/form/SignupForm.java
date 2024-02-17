package com.tutorial.tutorial.form;

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
  private String loginId;
  /** パスワード */
  private String password;
}
