package tmp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarnessV4 {

  // http://msdn.microsoft.com/zh-cn/library/ae5bf541(v=vs.90).aspx

  static final String review = "一直在这里买，东西不错速度有快,一如即他往,运费高,邮费便宜,速度给力,到货非常慢";

  static final String keyword = "很好|非常好|好评|不错|给力|推荐|朋友介绍|信赖|支持|相信|选择这个|满意|爱喝|囤货|囤着|一如..往|购买|回头客|优质|老客户|老顾客|正品|Good|good|GOOD|第*次|N次|n次|好几次|多次|可靠|赞|棒|依赖|好|一般|ok|Ok|OK|5分|五分|可以|好货|可以的|还行|hao|bucuo|keyi|HAO|Hao|nice|非常差";

  static final String keywordss = "(一如..往)";

  static final String kx =
  // "(运费|邮费)(便宜|包邮|贵|高|涨)";

  "^(速度)|(运费)?";

  public static void main(String[] args) {

    // String expression = "速度|快";
    //
    // String evalStr = "foofoofoo";

    Pattern pattern = Pattern.compile(kx);

    Matcher matcher = pattern.matcher(review);

    boolean found = false;

    while (matcher.find()) {

      String loginfo = String
          .format(
              "found the text [%s] , starting at index [%d]  and ending at index [%d]",
              matcher.group(), matcher.start(), matcher.end());

      System.out.println(loginfo);

      found = true;
    }
    if (!found) {
      System.out.println("No match found.");
    }
  }
}
