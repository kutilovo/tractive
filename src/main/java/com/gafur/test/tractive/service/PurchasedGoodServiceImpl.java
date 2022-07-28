package com.gafur.test.tractive.service;

import com.gafur.test.tractive.model.GoodMapping;
import com.gafur.test.tractive.model.PurchasedGood;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PurchasedGoodServiceImpl implements PurchasedGoodService {

  private Map<String, Integer> goodsQuantity = new HashMap<>();

  @Override
  public List<PurchasedGood> getPurchasedGoods(
      List<String> goodSkuList,
      Map<String, GoodMapping> goodMappings
  ) {
    List<PurchasedGood> purchasedGoods = new ArrayList<>();
    for (String goodSku : goodSkuList) {
      Integer goodCounter = goodsQuantity.get(goodSku);
      if (goodCounter != null) {
        goodsQuantity.put(goodSku, ++goodCounter);
      } else {
        goodsQuantity.put(goodSku, 1);
      }
    }

    for (Entry<String, GoodMapping> goodMapping : goodMappings.entrySet()) {
      purchasedGoods.add(new PurchasedGood(
          goodMapping.getValue().getVersion(),
          goodMapping.getValue().getEdition(),
          goodsQuantity.get(goodMapping.getKey())
      ));
    }
    return purchasedGoods;
  }
}
