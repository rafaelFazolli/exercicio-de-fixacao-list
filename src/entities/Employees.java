package entities;

public class Employees {
    private Integer id;
    private String name;
    private Double salary;

    public Employees(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void salaryIncrease(Double percent) {
        salary += salary * percent / 100.0;
    }

    public String toString() {
        return  "\n ID: " + id +
                "\n Name: " + name +
                "\n Salary: " + salary;
    };
}
