package com.kvn.classifier.ruleengine.rule;

import javax.rules.admin.Rule;

import com.kvn.classifier.common.LabelSet;

public abstract class BaseClassifierRule<T> implements Rule {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  public BaseClassifierRule(String name) {
    this(name, null);
  }

  private BaseClassifierRule(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public Object getProperty(Object paramObject) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setProperty(Object paramObject1, Object paramObject2) {
    // TODO Auto-generated method stub

  }

  //

  public abstract boolean eval(T input);

}
