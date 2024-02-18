package com.tutorial.tutorial.controller;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.tutorial.constant.MessageConst;
import com.tutorial.tutorial.form.LoginForm;
import com.tutorial.tutorial.service.LoginService;
import com.tutorial.tutorial.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面Controller
 * 
 * @author shimokawa
 * 
 * 
 */

@Controller
@RequiredArgsConstructor
public class LoginController {
  /** ログイン画面Service */
  private final LoginService service;

  /** PasswordEncorder */
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /** MessageSource */
  private final MessageSource messageSource;

  /**
   * 初期表示
   * 
   * @param model モデル
   * @param form  入力情報
   * @return 表示画面
   */
  @GetMapping("/login")
  public String view(Model model, LoginForm form) { // => Model…Controllerからhtmlへデータを受け渡すクラス
    return "login"; // =>login.html
  }

  /**
   * ログイン
   * 
   * @param model モデル
   * @param form  入力情報
   * @return 表示画面
   */
  @PostMapping("/login")
  public String login(Model model, LoginForm form) {
    var userInfo = service.searchUserById(form.getLoginId());
    boolean isCorrectUserAuth = userInfo.isPresent()
        && passwordEncoder.matches(form.getPassword(), userInfo.get().getPassword());
    // isCorrectUserAuthはboolean型の変数でIDまたはパスワードが異なっていればfalseになる
    if (isCorrectUserAuth) {
      return "redirect:/menu";
    } else {
      String errorMsg = AppUtil.getMessage(messageSource, MessageConst.LOGIN_WRONG_INPUT); 
      model.addAttribute("errorMsg", errorMsg);
      return "login";
    }
  }
}
