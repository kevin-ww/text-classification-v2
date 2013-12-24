package tmp;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarnessV5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new BufferedInputStream(System.in)));
    while (true) {
      System.out.print("\nEnter your regex: ");
      Pattern pattern = Pattern.compile(br.readLine());
      System.out.print("Enter input string to search: ");
      Matcher matcher = pattern.matcher(br.readLine());
      boolean found = false;
      while (matcher.find()) {
        System.out.println("I found the text \"" + matcher.group()
            + "\" starting at index " + matcher.start()
            + " and ending at index " + matcher.end() + ".");
        found = true;
      }
      if (!found) {
        System.out.println("No match         found.");
      }
    }
  }

  public static void regxChinese() {
    // 要匹配的字符串
    String source = "<span title='5 星级酒店' class='dx dx5'>";
    // 将上面要匹配的字符串转换成小写
    // source = source.toLowerCase();
    // 匹配的字符串的正则表达式
    String reg_charset = null;
    // "<span[^>]*?title='([0-9]*[\s|\S]*[u4E00-u9FA5]*)'[\s|\S]*class='[a-z]*[\s|\S]*[a-z]*[0-9]*'";

    Pattern p = Pattern.compile(reg_charset);
    Matcher m = p.matcher(source);
    while (m.find()) {
      System.out.println(m.group(1));
    }
  }

  public static void regxChinese1() {
    // 要匹配的字符串
    String source = "<span title='5 星级酒店' class='dx dx5'>";
    // 将上面要匹配的字符串转换成小写
    // source = source.toLowerCase();
    // 匹配的字符串的正则表达式
    String reg_charset = "<span[^>]*?title=\'([0-9]*[\\s|\\S]*[\u4E00-\u9FA5]*)\'[\\s|\\S]*class=\'[a-z]*[\\s|\\S]*[a-z]*[0-9]*\'";
    Pattern p = Pattern.compile(reg_charset);
    Matcher m = p.matcher(source);
    while (m.find()) {
      System.out.println(m.group(1));
    }
  }

}
