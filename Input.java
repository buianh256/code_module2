package src;

import java.util.Scanner;

public class Input {
    public static int Number(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập lại!");
            }
        }
    }
    public static int age(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try{
                int age = scanner.nextInt();
                boolean isValid = Regex.checkAge(String.valueOf(age));
                if (isValid && age >= 18 && age <=40){
                    return age;
                }else{
                    System.out.println("Độ tuổi không hợp lệ vui lòng nhập lại!");
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại!");
            }
        }
    }
    public static String idCode(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            try{
                String id = scanner.nextLine();
                boolean isValid = Regex.checkIdCode(id);
                if(isValid){
                    return id;
                }else {
                    System.out.println("Định dạng sai, mời nhập lại!");
                }
            }catch(Exception e){
                System.out.println("Kiểu dữ liệu bị sai!");
            }
        }
    }
    public static String checkString(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            try {
                String name = scanner.nextLine();
                boolean isValid = Regex.checkString(name);
                if(isValid){
                    return name;
                }else {
                    System.out.println("Định dạng sai, mời nhập lại!");
                }
            }catch (Exception e){
                System.out.println("Kiểu dữ liệu bị sai!");
            }
        }
    }
}
