/**
 * This is the Course class. It holds the information for a course.
 * @author Keith McGill
 * @version 12/6/12
 */
public class Course 
{
	public String name;
	public String crn;
	public String time;
	public StudentNode roster;
	
	/**
	 * This is the constructor for the class. It initializes a new course.
	 * @param initialName
	 * @param initialCRN
	 * @param initialTime
	 */
	public Course(String initialName, String initialCRN, String initialTime)
	{
		name = initialName;
		crn = initialCRN;
		time = initialTime;
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
	 * @return the crn
	 */
	public String getCrn() {
		return crn;
	}

	/**
	 * @param crn the crn to set
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the roster
	 */
	public StudentNode getRoster() {
		return roster;
	}
	
	/**
	 * This checks the course roster for a student.
	 * @return 
	 */
	public String checkCourseStudents(String target)
	   {
	      StudentNode cursor;
	      
	      for (cursor = roster; cursor != null; cursor = cursor.link)
	      {
	    	  if (cursor.getStu().getId().equalsIgnoreCase(target))
	    	  {
	    		  return target;
	    	  }
	      }
	      return null;
	   }
	
	/**
	 * @param roster the roster to set
	 */
	public void addStudent(Student student) 
	{
		roster = new StudentNode(student, roster);
	}
	
	/**
	 * This prints the course roster.
	 */
	public void printCourseStudents()
	   {
	      StudentNode cursor;
	      
	      for (cursor = roster; cursor != null; cursor = cursor.link)
	      {
	    	  System.out.println(cursor.getStu().getName() + " " + cursor.getStu().getId());
	      }
	   }
}
