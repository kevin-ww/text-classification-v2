package com.kvn.classifier.ruleengine.rule;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexRule<T> extends ClassifierRule<T> {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private List<String> expressions;

  protected Pattern regexPattern;

  public RegexRule(String name) {
    super(name);
  }

  public RegexRule(String name, List<String> expressions) {
    super(name);
    setExpressions(expressions);

  }

  /**
   * assume all the expressions in the list can be combined in one "OR" ;
   * 
   * limit of 65535 on the length of a String literal,TODO
   */
  protected void compileRegexExpressions() {

    StringBuffer combinedExpression = new StringBuffer();
    for (String expression : expressions) {
      combinedExpression.append(expression);
    }
    this.regexPattern = Pattern.compile(combinedExpression.toString());
  }

  public List<String> getExpressions() {
    return expressions;
  }

  public void setExpressions(List<String> expressions) {
    this.expressions = expressions;
    compileRegexExpressions();
  }

  public boolean isMatch(String text) {
    Matcher matcher = this.regexPattern.matcher(text);
    return matcher.find();
  }

  public abstract String getRuleLable();

  @Override
  public String toString() {
    final int maxLen = 10;
    return "RegexRule [ name="
        + getName()
        + ", description="
        + getDescription()
        + ",expressions="
        + (expressions != null ? expressions.subList(0,
            Math.min(expressions.size(), maxLen)) : null) + " ]";
  }
}
