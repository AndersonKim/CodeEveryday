import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TestClassAnalyzer {
    @Test
    public void testGetClassName() {
        ClassAnalyzer ca = new ClassAnalyzer(String.class);
        System.out.println(ca.get_longName());
        System.out.println(ca.get_shortName());
    }

    @Test
    public void testTestClassName() {
        ClassAnalyzer ca = new ClassAnalyzer(String.class);
        System.out.println(ca.genTestClassName());
        List ml = ca.genTestClassMethod();
        Iterator i = ml.iterator();
        System.out.println("---------------------method----------------------");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        /*assertThat(new CartoonCharacterEmailLookupService().getResults("looney"), allOf(
                not(empty()),
                containsInAnyOrder(
                        allOf(instanceOf(Map.class), hasEntry("id", "56"), hasEntry("email", "roadrunner@fast.org")),
                        allOf(instanceOf(Map.class), hasEntry("id", "76"), hasEntry("email", "wiley@acme.com"))
                )
        ));*/
    }
}
