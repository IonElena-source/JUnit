package teste;

import classes.IStudentValid;
import classes.Student;
import exceptii.ExceptieStudentValoriInvalide;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StudentTest {

    //test fixture
    Student student;
    public static final  String NUME;
    public static final int VARSTA= IStudentValid.VARSTA_MIN;
    public static final ArrayList<Integer> NOTE=new ArrayList<>();
    public static final int NR_NOTE=3;


    static {
        String numeInitial="";
        for(int i=0;i<IStudentValid.DIM_NUME_MIN;i++){
            numeInitial+="A";
        }
        NUME=numeInitial;
    }
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        for(int i=0;i<NR_NOTE;i++){
            NOTE.add(IStudentValid.NOTA_MAX);
        }
    }
    @Before
    public void setUp() throws Exception {
        student=new Student(NUME,VARSTA,NOTE);
    }

    @After
    public void tearDown() throws Exception {
    }

    //Right
    @Test
    public void testGetMedie2ZecimaleRight() throws ExceptieStudentValoriInvalide {

        ArrayList<Integer> note=new ArrayList<>(Arrays.asList(9,9,10));
        try {
            student.setNote(note);
        } catch (ExceptieStudentValoriInvalide exceptieStudentValoriInvalide) {
            fail("Excetpe generata de setNote");
        }

        float medieAsteptata=9.33F;
        float medieCalculata=student.getMedie2Zecimale();
        assertEquals(medieAsteptata,medieCalculata,0);
    }
    //Existence-ce faci daca resursa exista sau nu exista
    //-resursa nu exista, note este null

    @Test(expected = ExceptieStudentValoriInvalide.class)
    public void testGetMedie2ZecimaleExistenceNotNull() throws ExceptieStudentValoriInvalide {
        ArrayList<Integer> noteNull=null;
        try {
            student.setNote(noteNull);
        } catch (ExceptieStudentValoriInvalide exceptieStudentValoriInvalide) {
            fail("Exceptia a fost generata de setNote");
        }
            student.getMedie2Zecimale();

    }

    //ordering
    @Test
    public void testGetMedie2ZecimaleNoteSortateCrescator() throws ExceptieStudentValoriInvalide {
        ArrayList<Integer> note=new ArrayList<>(Arrays.asList(5,6,7,8,9));
        student.setNote(note);

        float medieAsteptata=7;
        float medieCalculata=student.getMedie2Zecimale();
        assertEquals(medieAsteptata,medieCalculata,0);

    }

    //cardinalitate
    //cardinalitate - 0
    @Test
    public void testGetMedie2ZecimaleZeroNote() throws ExceptieStudentValoriInvalide {
        ArrayList<Integer> note=new ArrayList<>();
        student.setNote(note);

        float medieAsteptata=0;
        float medieCalculata=student.getMedie2Zecimale();
        assertEquals(medieAsteptata,medieCalculata,0);
    }
    //cardinalitate - 1
    @Test
    public void testGetMedie2ZecimaleONota() throws ExceptieStudentValoriInvalide {
        int notaUnica=IStudentValid.NOTA_MIN;
        ArrayList<Integer> note=new ArrayList<>();
        note.add(notaUnica);
        student.setNote(note);

        float medieAsteptata=notaUnica;
        float medieCalculata=student.getMedie2Zecimale();
        assertEquals(medieAsteptata,medieCalculata,0);
    }
}