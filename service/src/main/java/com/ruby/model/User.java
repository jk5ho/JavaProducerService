package com.ruby.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

  @NonNull
  private String url;

  @NonNull
  private String button;

}