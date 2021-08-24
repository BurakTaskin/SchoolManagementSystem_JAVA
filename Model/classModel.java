public class classModel {
    private final String grade;
    private final String monday;
    private final String tuesday;
    private final String wednesday;
    private final String tursday;
    private final String friday;

    public classModel(String grade, String monday, String tuesday, String wednesday, String tursday, String friday) {
        this.grade = grade;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.tursday = tursday;
        this.friday = friday;
    }

    public String getGrade() {
        return grade;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getTursday() {
        return tursday;
    }

    public String getFriday() {
        return friday;
    }
}