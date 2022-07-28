package com.gafur.test.tractive.model;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
public class PurchasedGood {

  @NonNull
  int version;
  @Nullable
  String edition;
  @NonNull
  int quantity;
}
