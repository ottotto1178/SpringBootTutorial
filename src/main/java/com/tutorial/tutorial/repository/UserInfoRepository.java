package com.tutorial.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.tutorial.entity.UserInfo;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author shimokawa
 * 
 */

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
