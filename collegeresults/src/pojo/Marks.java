package pojo;

public class Marks {

	private Integer entryid;
	private String rollno;
	private String year;
	private String semester;
	private String exam;
	private String sessionalType;
	private String subject;
	private Integer maximum;
	private Integer minimum;
	private Integer obtained;
	
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getSessionalType() {
		return sessionalType;
	}
	public void setSessionalType(String sessionalType) {
		this.sessionalType = sessionalType;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getMaximum() {
		return maximum;
	}
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	public Integer getObtained() {
		return obtained;
	}
	public void setObtained(Integer obtained) {
		this.obtained = obtained;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Integer getEntryid() {
		return entryid;
	}
	public void setEntryid(Integer entryid) {
		this.entryid = entryid;
	}
}
