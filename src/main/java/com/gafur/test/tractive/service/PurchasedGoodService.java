package com.gafur.test.tractive.service;

import com.gafur.test.tractive.model.GoodMapping;
import com.gafur.test.tractive.model.PurchasedGood;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Checkout service for scan and calculate total price for goods
 */
public interface PurchasedGoodService {

  /**
   * Scan one good
   *
   * @param goodSkuSet sku of the good
   * @return pageable response with block parties
   */
  List<PurchasedGood> getPurchasedGoods(
      List<String> goodSkuList, 
      Map<String, GoodMapping> goodMapping
  );
}
