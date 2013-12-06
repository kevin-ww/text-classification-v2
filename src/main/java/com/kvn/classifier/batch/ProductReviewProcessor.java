package com.kvn.classifier.batch;

import org.springframework.batch.item.ItemProcessor;

import com.kvn.classifier.common.ProductReview;
import com.kvn.classifier.common.ProductReviewWithLabels;

public class ProductReviewProcessor implements
    ItemProcessor<ProductReview, ProductReviewWithLabels> {

  @Override
  public ProductReviewWithLabels process(ProductReview item) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("incoming:" + item);
    return new ProductReviewWithLabels(item, null);
  }

}
