package com.kvn.classifier.ruleengine.rule;

public class FlavorRule extends DefaultRegexRule {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final String LABEL = "flavor";

  public FlavorRule() {
    this("flavorrule-without-name");
  }

  public FlavorRule(String name) {
    super(name);
  }

  @Override
  public String getRuleLable() {
    return LABEL;
  }

}
