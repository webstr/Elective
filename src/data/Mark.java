package data;

public class Mark {
	private Integer id;
	private Course course;
	private User student;
	private String mark;
	private String reply;
	
	public Mark(Integer id, Course course, User student, String mark, String reply) {
		this.id = id;
		this.course = course;
		this.student = student;
		this.mark = mark;
		this.reply = reply;
	}
	
	public Integer getId() {
		return id;
	}
	public Course getCourse() {
		return course;
	}
	public User getStudent() {
		return student;
	}
	public String getMark() {
		return mark;
	}
	public String getReply() {
		return reply;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
