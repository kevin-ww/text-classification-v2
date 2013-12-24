package com.kvn.classifier.ruleengine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.rules.admin.Rule;

public class RuleSet implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  /**
   * RuleBase
   */
  private List<Rule> rules;

  public RuleSet(String name) {
    this(name, null);
  }

  public RuleSet(String name, String description) {
    this(name, description, null);
  }

  public RuleSet(String name, String description, List<Rule> rules) {
    // super();
    this.name = name;
    this.description = description;
    this.rules = rules;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return description;
  }

  public void addRule(Rule rule) {
    // validate the rule;
    this.rules.add(rule);
  }

  public Rule getRule(String ruleName) {
    Iterator<Rule> iter = this.rules.iterator();
    while (iter.hasNext()) {
      Rule rule = iter.next();
      if (rule.getName().equalsIgnoreCase(ruleName)) {
        return rule;
      }
    }
    return null;
  }

  public List<Rule> getRules() {
    return rules;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }

  @Override
  public String toString() {
    return "RuleSet [name=" + name + ", description=" + description
        + ", rules=" + rules + "]";
  }

}
