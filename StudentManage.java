package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManage {
    private ArrayList<Student> list;

    public StudentManage() {
        list = new ArrayList<Student>();
    }

    public void showStudent() {
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mã sinh viên:");
        String idCode = Input.idCode();
        System.out.println("Họ tên");
        String name = Input.checkString();
        System.out.println("Tuổi");
        int age = Input.age();
        System.out.println("Giới tính");
        String gender = Input.checkString();
        System.out.println("Địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Đim trung bình");
        double mediumScore = scanner.nextDouble();
        Student student = new Student(idCode, name, age, gender, address, mediumScore);
        list.add(student);
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên muốn xóa");
        String removeIdCode = scanner.nextLine();
        for (Student student : list) {
            if (student.getIdCode().equals(removeIdCode)) {
                list.remove(student);
            }
        }
    }

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        int edit;
        System.out.println("Nhập mã sinh viên cần sửa");
        String editID = scanner.nextLine();
        for (Student student : list) {
            if (student.getIdCode().equals(editID)) {
                do {
                    System.out.println("1. Mã sinh viên");
                    System.out.println("2. Họ tên");
                    System.out.println("3. Tuổi");
                    System.out.println("4. Giới tính");
                    System.out.println("5. Địa chỉ");
                    System.out.println("6. Điểm trung bình");
                    edit = scanner.nextInt();
                    switch (edit) {
                        case 1:
                            editId(student, scanner);
                            return;
                        case 2:
                            editName(student, scanner);
                            return;
                        case 3:
                            editAge(student, scanner);
                            return;
                        case 4:
                            editGender(student, scanner);
                            return;
                        case 5:
                            editAddress(student, scanner);
                            return;
                        case 6:
                            editMediumScore(student, scanner);
                            return;
                    }
                } while (true);
            }
        }
    }

    private static void editMediumScore(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập diem sinh viên cần sửa");
        double dtb = scanner.nextDouble();
        student.setMediumScore(dtb);
    }

    private static void editAddress(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập dia chi sinh viên cần sửa");
        String address = scanner.nextLine();
        student.setAddress(address);
    }

    private static void editGender(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập giới tính sinh viên cần sửa");
        String gender = Input.checkString();
        student.setGender(gender);
    }

    private static void editAge(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên cần sửa");
        int age = Input.Number();
        student.setAge(age);
    }

    private static void editName(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập ho tên sinh viên cần sửa");
        String name = Input.checkString();
        student.setName(name);
    }

    private static void editId(Student student, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Nhập mã sinh viên cần sửa");
        String id = Input.idCode();
        student.setIdCode(id);
    }

    public void sortStudent() {
        System.out.println("---- Sap xep sinh vien theo diem trung binh ----");
        System.out.println("Chọn chức năng theo số(để tiếp tục)");
        System.out.println("1. Sắp xếp diem trung binh tang dan");
        System.out.println("2. Sắp xếp diem trung binh giam dan");
        int choose = -1;
        do {
            choose = Input.Number();
            switch (choose) {
                case 1:
                    this.sortIncrease();
                    break;
                case 2:
                    this.sortDecrease();
                    break;
            }
        } while (choose != 3);
    }

    public void sortIncrease() {
        Collections.sort(this.list);
        this.showStudent();
    }

    public void sortDecrease() {
        Collections.sort(this.list);
        Collections.reverse(this.list);
        this.showStudent();
    }
    public void loadFromFile() throws IOException {
        BufferedReader reader2 = null;
        try {
            String filepath = "src/student.csv";
            FileReader reader = new FileReader(filepath);
            reader2 = new BufferedReader(reader);
            String line;

            while ((line = reader2.readLine()) != null) {
                String[] lines = line.split(",");

                if (lines.length >= 6) {
                    String id = lines[0];
                    String name = lines[1];
                    int age = Integer.parseInt(lines[2]);
                    String gender = lines[3];
                    String address = lines[4];
                    Double mediumScore = Double.parseDouble(lines[5]);
                    Student student = new Student(id, name, age,gender, address, mediumScore);
                    list.add(student);
                } else {
                    System.out.println("Invalid data in line: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } finally {
            if (reader2 != null) {
                reader2.close();
            }
        }
    }
    public void printToFile(Scanner scanner) throws IOException{
        System.out.println("Nhập đường link file:");
        String path = scanner.nextLine();
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
        oos.writeObject(list);
        oos.close();
    }
}
