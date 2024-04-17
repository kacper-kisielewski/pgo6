import java.util.Date;

public class Student {
    private static int studentNumberCount = 1;
    private final int currentSemester = 1;
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private String studentNumber;
    private StudyProgramme assignedProgramme;

    public Student(String fname, String lname, String email, String address, String phoneNumber, Date dateOfBirth) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        generateStudentNumber();
    }


    private void generateStudentNumber() {
        studentNumber = "s" + Student.studentNumberCount;
        Student.studentNumberCount++;
    }

    public void enrollStudent(StudyProgramme programme) {
        assignedProgramme = programme;
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
        if (assignedProgramme == null)
            throw new IllegalStateException("Student is not in any programme");
        return currentSemester;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}