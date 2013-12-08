package com.kvn.classifier.ruleengine.rule;

public class WordOfMouthRule extends DefaultRegexRule {

  public static final String LABEL = "StoreWOM";
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public WordOfMouthRule() {
    this("wom_rule_without_name");
  }

  public WordOfMouthRule(String name) {
    super(name);
  }

  @Override
  public String getRuleLable() {
    return LABEL;
  }

}
