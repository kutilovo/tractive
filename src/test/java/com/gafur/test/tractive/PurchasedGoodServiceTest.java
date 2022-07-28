package com.gafur.test.tractive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gafur.test.tractive.model.GoodMapping;
import com.gafur.test.tractive.model.PurchasedGood;
import com.gafur.test.tractive.service.PurchasedGoodService;
import com.gafur.test.tractive.service.PurchasedGoodServiceImpl;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class PurchasedGoodServiceTest {

  private final PurchasedGoodService purchasedGoodService = new PurchasedGoodServiceImpl();

  private final Map<String, GoodMapping> goodMappings = Map.of(
      "CVCD", new GoodMapping(1, "X"),
      "SDFD", new GoodMapping(2, "Z"),
      "DDDF", new GoodMapping(1, null)
  );

  private final List<String> products = List.of("CVCD", "SDFD", "DDDF", "SDFD");

  @Test
  public void totalsTest() {
    List<PurchasedGood> purchasedGoods = purchasedGoodService.getPurchasedGoods(
            products,
            goodMappings
        ).stream()
        .sorted(Comparator.comparing(PurchasedGood::getVersion))
        .collect(Collectors.toList());

    assertEquals(3, purchasedGoods.size());

    PurchasedGood cvcd = purchasedGoods.get(0);
    assertEquals(1, cvcd.getVersion());
    assertEquals("X", cvcd.getEdition());
    assertEquals(1, cvcd.getQuantity());

    PurchasedGood dddf = purchasedGoods.get(1);
    assertEquals(1, dddf.getVersion());
    assertEquals(1, dddf.getQuantity());

    PurchasedGood sdfd = purchasedGoods.get(2);
    assertEquals(2, sdfd.getVersion());
    assertEquals("Z", sdfd.getEdition());
    assertEquals(2, sdfd.getQuantity());
  }
}
