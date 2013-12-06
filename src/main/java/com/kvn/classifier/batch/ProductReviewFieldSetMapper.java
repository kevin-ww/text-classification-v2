package com.kvn.classifier.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.kvn.classifier.common.ProductReview;

public class ProductReviewFieldSetMapper implements
    FieldSetMapper<ProductReview> {

  @Override
  public ProductReview mapFieldSet(FieldSet fieldSet) throws BindException {

    if (fieldSet == null) {
      return null;
    }

    String uid = fieldSet.readString(0);

    String reviewText = fieldSet.readString(4);

    ProductReview review = new ProductReview(uid, reviewText);

    return review;

  }

}
