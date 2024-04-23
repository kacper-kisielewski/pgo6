import java.util.ArrayList;
import java.util.Date;

public class Student {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static int studentNumberCount = 1;
    private int currentSemester = 1;
    private final ArrayList<Grade> grades = new ArrayList<Grade>();
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private String studentNumber;
    private StudyProgramme assignedProgramme;
    private String status = "kandydat";
    private int ITNs = 0;

    public Student(String fname, String lname, String email, String address, String phoneNumber, Date dateOfBirth) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        generateStudentNumber();
        Student.students.add(this);
    }

    public static void promoteAllStudents() throws IllegalStateException {
        for (Student student : students) {
            student.promoteStudent();
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : students) {
            student.displayStudentInfo();
        }
    }

    public int getITNs() {
        return ITNs;
    }

    public void setITNs(int ITNs) {
        this.ITNs = ITNs;
    }

    public String getStatus() {
        return status;
    }

    private void generateStudentNumber() {
        studentNumber = "s" + Student.studentNumberCount;
        Student.studentNumberCount++;
    }

    public void enrollStudent(StudyProgramme programme) {
        assignedProgramme = programme;
        status = "student";
    }

    public void promoteStudent() throws IllegalStateException {
        if (ITNs > assignedProgramme.getNumberOfPossibleITNs()) {
            throw new IllegalStateException("Cannot promote student that has more than allowed ITNs");
        } else {
            currentSemester++;
        }
    }

    public String getFullName() {
        return fname + " " + lname;
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + getFullName());
        System.out.println("Index Number: " + studentNumber);
        System.out.println("Programme: " + assignedProgramme.name);
        System.out.println("Semester: " + currentSemester);
        System.out.println("Grades: ");
        printGrades();
    }

    public void printGrades() {
        for (Grade grade : grades) {
            grade.print();
        }
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void addGrade(int grade, String subjectName) {
        grades.add(new Grade(grade, subjectName));
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudyProgramme getAssignedProgramme() {
        return assignedProgramme;
    }

    public int getCurrentSemester() throws IllegalStateException {
        if (assignedProgramme == null) throw new IllegalStateException("Student is not in any programme");
        return currentSemester;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}