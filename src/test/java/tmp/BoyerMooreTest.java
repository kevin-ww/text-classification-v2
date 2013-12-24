package tmp;
import java.util.Arrays;

public class BoyerMooreTest {

  final static char[] sentence = "here is an simple example".toCharArray();

  final static char[] pattern = "example".toCharArray();

  public static void main(String[] args) {

    // System.out.println(Arrays.toString(sentence));

    for (int index = 0; index < sentence.length; ++index) {

      if (index > 9) {
        System.out.print(String.format("[ %s]", sentence[index]));
      } else {
        System.out.print(String.format("[%s]", sentence[index]));
      }

    }

    System.out.println("");

    for (int index = 0; index < sentence.length; ++index) {
      System.out.print(String.format("[%d]", index));
    }
    System.out.println("");

    int index = pattern.length - 1;

    char lastChar = pattern[index];

    System.out.println("searching " + Arrays.toString(pattern) + " in "
        + Arrays.toString(sentence));

    find(lastChar, index, index);

  }

  /**
   * @param character
   * @param patternIndex
   *          character index in pattern character array;
   * @param sentenceIndex
   *          start index of the searching sentence;
   */
  public static void find(char character, int patternIndex, int sentenceIndex) {

    System.out.print(String.format(
        "searching  [%s] ,patternIndex [%d] ,in sentence at index [%d]",
        character, patternIndex, sentenceIndex));

    char sentenceChar = sentence[sentenceIndex];
    
    char lastChar = character;

    System.out.print(String.format(" ,now comparing [%s]|[%s]", character,
        sentenceChar));

    if (sentenceChar == lastChar) {
      // backward searching
      System.out.println(" match, backward searching");
      char previousChar = pattern[--patternIndex];
      find(previousChar, patternIndex, --sentenceIndex);
    } else {
      // forward searching
      // to check if pattern contains this character;
      int position = revertPositionInPattern(sentenceChar);
      // 后移位数 = 坏字符的位置 - 搜索词中的上一次出现位置
      // 后移位数 = 好后缀的位置 - 搜索词中的上一次出现位置

      // Boyer-Moore算法的基本思想是，每次后移这两个规则之中的较大值。
      // 更巧妙的是，这两个规则的移动位数，只与搜索词有关，与原字符串无关。因此，可以预先计算生成《坏字符规则表》和《好后缀规则表》。使用时，只要查表比较一下就可以了。
      if (position == 0) {
        sentenceIndex = sentenceIndex + 1 + pattern.length;
      } else {
        sentenceIndex = sentenceIndex + position;
      }
      System.out.println(" not match, forward searching");
      find(lastChar, patternIndex, sentenceIndex);
    }
  }

  public static int revertPositionInPattern(char character) {

    for (int index = 0; index < pattern.length; ++index) {
      if (pattern[index] == character) {
        return (pattern.length - 1 - index);
      }
    }

    return 0;// not 0;

  }

}
