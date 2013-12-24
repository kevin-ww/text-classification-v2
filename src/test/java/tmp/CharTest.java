package tmp;
import java.util.Arrays;

public class CharTest {

  final static String setence = "here is an simple example";

  final static String pattern = "example";

  public static void main(String[] args) {

    find(setence.toCharArray(), pattern.toCharArray());

  }

  private static void find(char[] sentence, char[] pattern) {

    int endIndex = pattern.length - 1;

    char lastChar = pattern[endIndex];

    find(lastChar, pattern, sentence, endIndex);

  }

  public static void find(char chartacter, int index) {
    

  }

  public static void find(char character, char[] pattern, char[] sentence,
      int endIndex) {

    String info = String.format(
        "searching  [%s]  in sentence %s  at index [%d]", character,
        Arrays.toString(sentence), endIndex);

    System.out.print(info);

    char matchingChar = sentence[endIndex];

    System.out.print(", now comparing [" + matchingChar + "] with ["
        + character + "]");

    if (matchingChar == character) {

      // backward searching;
      // continue to check the previous character;
      char previousChar = pattern[--endIndex];

      print(" , match , backward  searching");

      find(previousChar, pattern, sentence, endIndex);

    } else {

      // forward searching;

      print(" , not match, forward searching");

      int size = sentence.length - endIndex;

      char[] slicedSentence = new char[size];

      System.arraycopy(sentence, endIndex, slicedSentence, 0, size);

      find(character, pattern, slicedSentence, endIndex);

    }

  }

  public static void print(String info, Object... args) {
    System.out.println(String.format(info, args));
  }

}
