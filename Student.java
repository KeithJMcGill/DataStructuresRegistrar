/**
 * This is the Student class. It holds the information for a student.
 * @author Keith McGill
 * @version 12/6/12
 */
public class Student 
{
	public String name;
	public String id;
	public CourseNode schedule;
	
	/**
	 * This is the constructor for the class. It initializes a new student.
	 * @param initialName
	 * @param initialID
	 */
	public Student(String initialName, String initialID)
	{
		name = initialName;
		id = initialID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the schedule
	 */
	public CourseNode getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void addCourse(Course course) 
	{
		schedule = new CourseNode(course, schedule);
	}
	
	/**
	 * This prints the student schedule.
	 */
	public void printStudentCourses()
	   {
	      CourseNode cursor;
	      
	      for (cursor = schedule; cursor != null; cursor = cursor.link)
	      {
	    	  System.out.println(cursor.getCou().getName() + " " + cursor.getCou().getCrn() + 
	    			  " " + cursor.getCou().getTime());
	      }
	   }
}