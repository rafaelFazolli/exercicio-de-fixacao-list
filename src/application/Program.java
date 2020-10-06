package application;

import entities.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employees> employeeList = new ArrayList<>();

        System.out.println("How many employees will be registered?: ");
        int quantity = sc.nextInt();

        for(int i = 0; i < quantity; i++) {
            sc.nextLine();
            System.out.println("Employee #" + (i + 1));
            System.out.println("What is the employee's id?: ");
            int id = sc.nextInt();

            while(hasId(employeeList, id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.println("What is the employee's name?: ");
            String name = sc.next();

            System.out.println("What is the employee's salary?: ");
            Double salary = sc.nextDouble();

            employeeList.add(new Employees(id, name, salary));
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Integer idPosition = position(employeeList, id);

        if(idPosition == null)  {

            System.out.println("This id does not exist!");
        } else {
            System.out.println("Enter the percent:" );
            Double percent = sc.nextDouble();

            employeeList.get(idPosition).salaryIncrease(percent);
        }

        for(Employees employee: employeeList) {
            System.out.println(employee);
        }

        sc.close();
    }

    public static Integer position(List<Employees> list, int id) {
        for(int i = 0; i < list.size(); i ++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static Boolean hasId(List<Employees> list, int id) {
        Employees employee = list.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);

        return employee != null;
    }
}
