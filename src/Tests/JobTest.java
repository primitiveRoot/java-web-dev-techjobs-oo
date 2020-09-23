package Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JobTest {
    public static Job job1;
    public static Job job2;
    public static Job job3;

    @Before
    public void createJobObjects() {

        job1 = new Job();
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));


    }

    @Test
    public void testSettingJobId(){
        int id1 = job1.getId();
        int id2 = job2.getId();
        assertEquals(id1, id2 - 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job2 != null);

        assertEquals(job2.getName(), "Product tester");

        assertTrue(job2.getEmployer() instanceof Employer);
        assertEquals(job2.getEmployer().getValue(), "ACME");

        assertTrue(job2.getLocation() instanceof Location);
        assertEquals(job2.getLocation().getValue(), "Desert");

        assertTrue(job2.getPositionType() instanceof PositionType );
        assertEquals(job2.getPositionType().getValue(), "Quality control");

        assertTrue(job2.getCoreCompetency() instanceof CoreCompetency );
        assertEquals(job2.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job2.equals(job3));
    }

    @Test
    public void testToString(){
        assertTrue(job2.toString().startsWith("\n") && job2.toString().endsWith("\n"));
    }
    @Test
    public void testLines(){
        for(String line : job2.toString().split("\n")){
            for(String segment: line.split(":")){
                assertFalse(segment.equals(" null"));
            }
        }
    }

}
