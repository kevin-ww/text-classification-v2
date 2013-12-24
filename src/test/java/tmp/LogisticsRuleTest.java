package tmp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kvn.classifier.common.ProductReview;
import com.kvn.classifier.ruleengine.rule.LogisticsRule;

public class LogisticsRuleTest extends TestCase {

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public static void testCase2() throws Exception {

    final String ruleConfigXml = "com/kvn/classifier/ruleengine/rule/Logistics_Rule.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(ruleConfigXml);

    LogisticsRule rule = (LogisticsRule) ctx.getBean("LogisticsRule");

    System.out.println(rule);

    String reviewText = "一直在你们家购买，感觉奶粉是保真的。就是发货速度稍微再快一些就好了。先谢谢了";

    ProductReview productReview = new ProductReview("nulluid", reviewText);

    boolean isBelongsTo = rule.eval(productReview);

    System.out.println(isBelongsTo);

  }

  // public static void testMatch() throws Exception {
  //
  // String expression =
  // "很好、非常好、好评、不错、给力、推荐、朋友介绍、信赖、支持、相信、选择这个、满意、爱喝、囤货、囤着、一直、一如*往、购买";
  // Pattern pattern = Pattern.compile(expression);
  //
  // String input = "haa";
  //
  // // Matcher m =pattern.matcher(input)
  // // boolean isMatch =
  // }
  //
  public static void main(String[] args) throws Exception {
    // 生成 Pattern 对象并且编译一个简单的正则表达式"Kelvin"
    // Pattern p = Pattern.compile("Kevin");
    // // 用 Pattern 类的 matcher() 方法生成一个 Matcher 对象
    // Matcher m = p.matcher("Kelvin Li and Kelvin Chan are both working in "
    // + "Kelvin Chen's KelvinSoftShop company");
    // boolean isMatch = m.find();
    //
    // System.out.println(isMatch);

    // StringBuffer sb = new StringBuffer();
    // int i = 0;
    // // 使用 find() 方法查找第一个匹配的对象
    // boolean result = m.find();
    // // 使用循环将句子里所有的 kelvin 找出并替换再将内容加到 sb 里
    // while (result) {
    // i++;
    // m.appendReplacement(sb, "Kevin");
    // System.out.println("第" + i + "次匹配后 sb 的内容是：" + sb);
    // // 继续查找下一个匹配对象
    // result = m.find();
    // }
    // // 最后调用 appendTail() 方法将最后一次匹配后的剩余字符串加到 sb 里；
    // m.appendTail(sb);
    // System.out.println("调用 m.appendTail(sb) 后 sb 的最终内容是 :" + sb.toString());
  }

}
