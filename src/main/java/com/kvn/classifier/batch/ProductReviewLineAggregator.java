package com.kvn.classifier.batch;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.kvn.classifier.common.ProductReviewWithLabels;

public class ProductReviewLineAggregator implements
    LineAggregator<ProductReviewWithLabels> {

  @Override
  public String aggregate(ProductReviewWithLabels item) {
    System.out.println(Thread.currentThread().getName() + " now writing out "
        + item);
    return item.toString();
  }

}
