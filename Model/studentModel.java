public class studentModel {
    private String id;
    private String name;
    private String lastName;
    private String age;
    private String grade;
    private String fee;

    public studentModel(String id, String name, String lastName, String age, String grade, String fee) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
        this.fee = fee;
    }
    
    public studentModel(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getFee() {
        return fee;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
    
    
    
}