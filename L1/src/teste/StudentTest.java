package teste;

import classes.Student;
import exceptii.ExceptieStudentVarstaInvalida;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {

    //test fixture
    public static final String nume="Gigel";
    public static final int varsta=20;
    public static final ArrayList<Integer> note=new ArrayList<>();
    Student student;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        note.add(9);
        note.add(8);
    }
    @Before
    public void setUp() throws Exception {
        student=new Student(nume,varsta,note);
    }

    @After
    public void tearDown() throws Exception {

    }
    @Ignore
    @Test
    public void test(){
        fail("Not yet implemented");
    }

    //Right-Right Bicept
    //Conformance

    @Test
    public void testConstructorRightInitializareAtribute(){
        String nume="Gigel";
        int varsta=20;
        ArrayList<Integer> note=new ArrayList<>();
        note.add(8);
        note.add(7);
        Student student=new Student(nume,varsta,note);
        assertEquals("Numele nu este initializat corect",nume,student.getNume());
        assertEquals("Varsta nu este initializat corect",varsta,student.getVarsta());
        for(int i=0;i<note.size();i++){
            assertEquals("Nota nu este initializata corect",(int)note.get(i),student.getNota(i));
        }

    }

    @Test
    public void testConstructorRightCreareObiect(){
        try{
            Student student=new Student(nume,varsta,note);
            assertNotNull(student);
        }
        catch (Exception e){
            fail("Constructorul a generat exceptie pentru valori corecte");
        }

    }

    @Test
    public void testSetVarstaRight(){
        int varstaDiferita=varsta+1;
        student.setVarsta(varstaDiferita);
        assertEquals(varstaDiferita,student.getVarsta());
    }

    @Test
    public void testGetMedie2ZecimaleRight(){
        ArrayList<Integer> note=new ArrayList<>();
        note.add(9);
        note.add(9);
        note.add(10);
        student.setNote(note);
        float medieAsteptata=9.33F;
        float medieCalculata=student.getMedie2Zecimale();
        assertEquals(medieAsteptata,medieCalculata);
    }

    //error condition
    @Test(expected = ExceptieStudentVarstaInvalida.class)
    public void testSetVarstaError(){
        int varstaGresit=-23;
        student.setVarsta(varstaGresit);
//        try{
//            student.setVarsta(varstaGresit);
//            fail("Nu am primit exceptie");
//        }
//        catch (ExceptieStudentVarstaInvalida e){
//            assertTrue("Am primit exceptie",true);
//        }


    }
}