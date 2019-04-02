//Student Class to create objects for Students
public class Student {
    private String name;
    private float cgpa;
    private int token;
    //Constructor
    public Student(String name, float cgpa, int token) {
        this.name = name;
        this.cgpa = cgpa;
        this.token = token;
    }
    String getName(){return name;}
    void setName(String name){this.name = name;}
    float getCgpa() {return cgpa;}
    void setCgpa(float cgpa){this.cgpa = cgpa;}
    int getToken(){return token;}
    void setToken(int token){this.token = token;}
}