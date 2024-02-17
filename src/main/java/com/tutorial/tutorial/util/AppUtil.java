package com.tutorial.tutorial.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * アプリケーション共通クラス
 * 
 * @author shimokawa
 * 
 */
public class AppUtil {
  /**
   * メッセージIDからメッセージを取得する
   * 
   * @param messageSource メッセージソース
   * @param key           メッセージキー
   * @param params        置換文字群
   * @return メッセージ
   */
  @SuppressWarnings("null")
  public static String getMessage(MessageSource messageSource, String key, Object... params) {
    return messageSource.getMessage(key, params, Locale.JAPAN);
  }
}
