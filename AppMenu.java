package src;

import java.io.IOException;
import java.util.Scanner;

public class AppMenu {
    public static void main(String[] args) throws IOException {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
        System.out.println("Chọn chức năng theo số(để tiếp tục)");
        StudentManage student = new StudentManage();
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng:");
            choose = Input.Number();
            switch (choose) {
                case 1:
                    student.showStudent();
                    break;
                case 2:
                    student.addStudent();
                    break;
                case 3:
                    student.updateStudent();
                    break;
                case 4:
                    student.removeStudent();
                    break;
                case 5:
                    student.sortStudent();
                    break;
                case 6:
                    student.loadFromFile();
                    break;
                case 7:
                    student.printToFile(scanner);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
            }
        } while (choose != 9);
    }
}
