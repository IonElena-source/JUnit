package classes;

import exceptii.ExceptieStudentValoriInvalide;

import java.util.ArrayList;

public class Student implements IStudentValid {

    String nume;
    int varsta;
    ArrayList<Integer> note;

    public Student(String nume, int varsta, ArrayList<Integer> note) {
        super();
        this.nume = nume;
        this.varsta = varsta;
        this.note = note;
    }

    public String getNume() throws ExceptieStudentValoriInvalide {
        return nume;
    }

    public void setNume(String nume) throws ExceptieStudentValoriInvalide {
        this.nume = nume;
    }

    public int getVarsta() throws ExceptieStudentValoriInvalide {
        return varsta;
    }

    public void setVarsta(int varsta) throws ExceptieStudentValoriInvalide{
        this.varsta = varsta;
    }

    public void setNote(ArrayList<Integer> note) throws ExceptieStudentValoriInvalide{
        this.note = note;
    }

    public int getNrNote() {
        return this.note.size();
    }

    public int getNota(int index) {
        return this.note.get(index);
    }

    public float getMedie2Zecimale() throws ExceptieStudentValoriInvalide {
        if(this.note==null){
            throw  new  ExceptieStudentValoriInvalide();
        }
        float suma=0;
        for(int nota:this.note){
            suma+=nota;
        }
        float medie=suma/this.note.size();
        return (int)(medie*100)/100.0f;
    }
}
