package com.tutorial.tutorial.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.tutorial.constant.MessageConst;
import com.tutorial.tutorial.entity.UserInfo;
import com.tutorial.tutorial.form.SignupForm;
import com.tutorial.tutorial.service.SignupService;
import com.tutorial.tutorial.util.AppUtil;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面Controller
 * 
 * @author shimokawa
 * 
 * 
 */

@Controller
@RequiredArgsConstructor
public class SignupController {
  /** ユーザー登録画面Service */
  private final SignupService service;

  /** MessageSource */
  private final MessageSource messageSource;

  /**
   * 初期表示
   * 
   * @param model モデル
   * @param form  入力情報
   * @return 表示画面
   */
  @GetMapping("/signup")
  public String view(Model model, SignupForm form) {
    return "signup";
  }

  /**
   * ユーザー登録
   * 
   * @param model モデル
   * @param form  入力情報
   * @return 表示画面
   */
  @PostMapping("/signup")
  public void signup(Model model, SignupForm form) {
    var userInfoOpt = service.registerUserInfo(form);
    String message = AppUtil.getMessage(messageSource, judgeMessageKey(userInfoOpt));
    model.addAttribute("message", message);
  }

  /**
   * ユーザー情報の登録結果メッセージキーの判別
   * 
   * @param userInfoOpt 登録結果(登録済みだった場合はEmpty)
   * @return メッセージキー
   */
  private String judgeMessageKey(Optional<UserInfo> userInfoOpt) {
    if (userInfoOpt.isEmpty()) {
      return MessageConst.SIGNUP_EXISTED_LOGIN_ID;
    } else {
      return MessageConst.SIGNUP_REGISTERD_SUCCEED;
    }
  }
}
