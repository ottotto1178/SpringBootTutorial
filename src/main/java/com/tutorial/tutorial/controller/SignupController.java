package com.tutorial.tutorial.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.tutorial.constant.MessageConst;
import com.tutorial.tutorial.constant.SignupMessage;
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
   * @param model    モデル
   * @param form     入力情報
   * @param bdResult 入力チェック結果
   * @return 表示画面
   */
  @PostMapping("/signup")
  public void signup(Model model, @Validated SignupForm form, BindingResult bdResult) {
    if (bdResult.hasErrors()) {
      editGuideMessage(model, MessageConst.FORM_ERROR, true);
      return;
    }
    var userInfoOpt = service.registerUserInfo(form);
    var signupMessage = judgeMessageKey(userInfoOpt);
    editGuideMessage(model, signupMessage.getMessageId(), signupMessage.isError());
  }

  /**
   * 画面に表示するガイドメッセージを設定する
   * 
   * @param model     モデル
   * @param messageId メッセージID
   * @param isError エラー有無
   */
  private void editGuideMessage(Model model, String messageId, boolean isError) {
    String message = AppUtil.getMessage(messageSource, MessageConst.FORM_ERROR);
    model.addAttribute("message", message);
    model.addAttribute("isError", true);
  }

  /**
   * ユーザー情報の登録結果メッセージキーの判別
   * 
   * @param userInfoOpt 登録結果(登録済みだった場合はEmpty)
   * @return メッセージキー
   */
  private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt) {
    if (userInfoOpt.isEmpty()) {
      return SignupMessage.EXISTED_LOGIN_ID;
    } else {
      return SignupMessage.SUCCEED;
    }
  }
}
