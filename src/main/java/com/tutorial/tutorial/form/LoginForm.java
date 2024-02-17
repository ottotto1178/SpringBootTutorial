package com.tutorial.tutorial.form;

import lombok.Data;

/**
 * ログイン画面Form
 * 
 * @author shimokawa
 * 
 */
@Data
public class LoginForm {
  /** ログインID */
  private String loginId;
  /** パスワード */
  private String password;
}
