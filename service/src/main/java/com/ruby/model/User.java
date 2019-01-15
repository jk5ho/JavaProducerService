package com.ruby.model;

import lombok.Data;

@Data
public class User {

  private String url;
  private String button;

  public User(String url, String button) {
    this.url = url;
    this.button = button;
  }

}