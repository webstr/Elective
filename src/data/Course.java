package data;

public class Course {
	private Integer id;
	private String name;
	private User teacher;

	public Course(String name, User teacher) {
		this.name = name;
		this.teacher = teacher;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", teacher=" + teacher
				+ "]";
	}

}
