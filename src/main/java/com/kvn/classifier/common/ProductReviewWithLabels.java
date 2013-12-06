package com.kvn.classifier.common;

import java.util.Arrays;

public class ProductReviewWithLabels {

  private ProductReview originalProductReview;

  private String[] labels;

  public ProductReviewWithLabels(ProductReview originalProductReview) {
    this(originalProductReview, null);
  }

  public ProductReviewWithLabels(ProductReview originalProductReview,
      String[] labels) {
    this.originalProductReview = originalProductReview;
    this.labels = labels;
  }

  public ProductReview getOriginalProductReview() {
    return originalProductReview;
  }

  public void setOriginalProductReview(ProductReview originalProductReview) {
    this.originalProductReview = originalProductReview;
  }

  public String[] getLabels() {
    return labels;
  }

  public void setLabels(String[] labels) {
    this.labels = labels;
  }

  @Override
  public String toString() {
    return "ProductReviewWithLabels [originalProductReview="
        + originalProductReview + ", labels=" + Arrays.toString(labels) + "]";
  }

}
