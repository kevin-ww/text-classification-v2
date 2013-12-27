package com.kvn.classifier.batch;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.kvn.classifier.common.ProductReview;
import com.kvn.classifier.common.ProductReviewWithLabels;
import com.kvn.classifier.core.RuleBasedMultilabelClassifier;

public class ProductReviewProcessor implements
    ItemProcessor<ProductReview, ProductReviewWithLabels> {

  @Override
  public ProductReviewWithLabels process(ProductReview item) throws Exception {

    System.out.println(Thread.currentThread().getName()+ " now processing :" + item);

    List<String> lables = RuleBasedMultilabelClassifier.getInstance()
        .classifer(item);

    return new ProductReviewWithLabels(item, lables);

  }

}
