package src;

public class Student implements Comparable<Student> {
    private String idCode;
    private String name;
    private int age;
    private String gender;
    private String address;
    private Double mediumScore;

    public Student(String idCode, String name, int age, String gender, String address, double mediumScore) {
        this.idCode = idCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(Double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idCode='" + idCode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mediumScore=" + mediumScore +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getMediumScore().compareTo(o.getMediumScore());
    }
}
