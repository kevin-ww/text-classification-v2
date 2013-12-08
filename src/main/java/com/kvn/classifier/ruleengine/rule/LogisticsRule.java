package com.kvn.classifier.ruleengine.rule;

public class LogisticsRule extends DefaultRegexRule {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final String LABEL = "Logistics";

  public LogisticsRule() {
    this("logisticsRule-without-name");
  }

  public LogisticsRule(String name) {
    super(name);
  }

  @Override
  public String getRuleLable() {
    return LABEL;
  }

}
