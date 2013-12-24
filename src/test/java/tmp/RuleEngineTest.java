package tmp;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.rules.ConfigurationException;
import javax.rules.InvalidRuleSessionException;
import javax.rules.RuleExecutionSetNotFoundException;
import javax.rules.RuleRuntime;
import javax.rules.RuleServiceProvider;
import javax.rules.RuleServiceProviderManager;
import javax.rules.RuleSessionCreateException;
import javax.rules.RuleSessionTypeUnsupportedException;
import javax.rules.StatelessRuleSession;
import javax.rules.admin.RuleAdministrator;
import javax.rules.admin.RuleExecutionSet;
import javax.rules.admin.RuleExecutionSetCreateException;
import javax.rules.admin.RuleExecutionSetRegisterException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kvn.classifier.common.ProductReview;
import com.kvn.classifier.ruleengine.RuleSet;
import com.kvn.classifier.ruleengine.UriConstants;
import com.kvn.classifier.ruleengine.rule.FlavorRule;
import com.kvn.classifier.ruleengine.rule.LogisticsRule;
import com.kvn.classifier.ruleengine.util.RuleEngineLog;

public class RuleEngineTest {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void main(String[] args) throws ConfigurationException,
      RuleExecutionSetCreateException, IOException,
      RuleSessionTypeUnsupportedException, RuleSessionCreateException,
      RuleExecutionSetNotFoundException, InvalidRuleSessionException,
      ClassNotFoundException, RuleExecutionSetRegisterException {

    // rule engine server side:

    // steps:

    String ruleEngineServiceUri = UriConstants.RULE_ENGINE_SERVICE_URI;

    Class.forName(UriConstants.RULE_SERVICE_PROVIDER_CLASS_NAME);

    RuleServiceProvider serviceProvider = RuleServiceProviderManager
        .getRuleServiceProvider(ruleEngineServiceUri);

    RuleAdministrator ruleAdministrator = serviceProvider
        .getRuleAdministrator();

    RuleEngineLog.debug(ruleAdministrator.toString());

    Map params = null;
    // InputStream stream = null;

    String bindUri = null;

    LogisticsRule logisticsRule = buildLogisticsRule();

    FlavorRule flavorRule = buildFlavorRule();

    RuleSet ruleSet = new RuleSet("multi-logisitic--ruleset");

    ruleSet.addRule(logisticsRule);
    ruleSet.addRule(flavorRule);
    // ruleSet.add(logisticsRule1);

    RuleExecutionSet ruleExecutionSet = ruleAdministrator
        .getLocalRuleExecutionSetProvider(params).createRuleExecutionSet(
            ruleSet, null);

    bindUri = ruleExecutionSet.getName();

    ruleAdministrator.registerRuleExecutionSet(bindUri, ruleExecutionSet, null);

    RuleEngineLog.debug(ruleExecutionSet);
    //
    RuleRuntime ruleRunTime = serviceProvider.getRuleRuntime();

    StatelessRuleSession srs = (StatelessRuleSession) ruleRunTime
        .createRuleSession(bindUri, params, RuleRuntime.STATELESS_SESSION_TYPE);

    List inputList = new LinkedList();

    String productReview1 = "一直在你们家购买，感觉奶粉是保真的。就是发货速度稍微再快一些就好了。先谢谢了";

    String productReview2 = "说什么原装进口的  但是和我原本进口的奶粉还是有区别    奶很甜  宝宝吃了这个奶粉后胃口很差  都不爱吃其他东西  本来每天定时有吃两顿饭的  现在吃了这个奶粉后  饭也不要吃了   现在一个没有开  另一罐开了放着没有喝";

    ProductReview pr1 = new ProductReview("uid1", productReview1);

    ProductReview pr2 = new ProductReview("uid2", productReview2);

    inputList.add(pr1);
    inputList.add(pr2);

    // inputList.add(new String("Bar"));
    // inputList.add(new Integer(5));
    // inputList.add(new Float(6));
    List resultList = srs.executeRules(inputList);

    // release the session
    srs.release();

    // System.out.println("executeRules: " + resultList);
    for (Object o : resultList) {
      System.out.println(o);
    }

  }

  private static FlavorRule buildFlavorRule() {

    final String ruleConfigXml = "com/kvn/classifier/ruleengine/rule/Flavor_Rule.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(ruleConfigXml);

    FlavorRule rule = (FlavorRule) ctx.getBean("FlavorRule");

    return rule;

  }

  private static LogisticsRule buildLogisticsRule() {

    final String ruleConfigXml = "com/kvn/classifier/ruleengine/rule/Logistics_Rule.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(ruleConfigXml);

    LogisticsRule rule = (LogisticsRule) ctx.getBean("LogisticsRule");

    return rule;
  }

}
