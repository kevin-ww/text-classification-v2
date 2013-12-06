package com.kvn.classifier;

import java.util.Map;

public class ClassificationResult<T> implements Comparable<T> {

  Map<T, Double> belongToClasses;

  @Override
  public int compareTo(T o) {
    // TODO Auto-generated method stub
    return 0;
  }

}
