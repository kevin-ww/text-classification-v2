import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MultiResourcePartitionerUT {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    // fail("Not yet implemented");

    String jobConfigXml = "f://tmp//batch//partitionFileJob.xml";

    ApplicationContext ctx = new FileSystemXmlApplicationContext(jobConfigXml);

    // SimpleJobLauncher jobLuncher = (SimpleJobLauncher) ctx
    // .getBean("jobLauncher");

    MockMultiResourcePartitioner x = (MockMultiResourcePartitioner) ctx
        .getBean("partitioner");

    System.out.println(x);
  }

  @Test
  public void testCase1() {
    MockMultiResourcePartitioner x = new MockMultiResourcePartitioner();
    String fileResourcePattern = "file:xxxE:\\wrk\\text-classification-v2\\src\\main\\resources\\data\\reviews\\reviews-*.txt";
    // x.setResources(fileResourcePattern);

  }

}
