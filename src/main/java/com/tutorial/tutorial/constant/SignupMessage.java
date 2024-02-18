package com.tutorial.tutorial.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SignupMessage {
  SUCCEED(MessageConst.SIGNUP_REGISTERD_SUCCEED, false),
  EXISTED_LOGIN_ID(MessageConst.SIGNUP_EXISTED_LOGIN_ID, true);

  private String messageId;
  private boolean isError;
}
