package batch;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class MultiJobTest extends TestCase {

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public static void testCase1() throws Exception {

    final String jobConfigXml = "product_review_classifier_job.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(jobConfigXml);

    Object x = ctx.getBean("simpleJob");

    System.out.println(x);
  }

}
