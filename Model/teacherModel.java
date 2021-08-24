public class teacherModel {
    
    private final String branch;
    private final String name;
    private final String lastName;
    private final String salary;

    public teacherModel(String branch, String name, String lastName, String salary) {
        this.branch = branch;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getBranch() {
        return branch;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSalary() {
        return salary;
    }
    
}