/**
 * This is the StudentNode class. It holds the nodes for the students.
 * @author Keith McGill
 * @version 12/6/12
 */
public class StudentNode
{
	public Student stu;
	public StudentNode link;
	
	/**
	 * This is the constructor for the class. It initializes a link.
	 * @param initialSTU
	 * @param initialLink
	 */
	public StudentNode(Student initialSTU, StudentNode initialLink)
	{
		stu = initialSTU;
		link = initialLink;
	}
	/**
	 * @return the stu
	 */
	public Student getStu() {
		return stu;
	}
	
	/**
	 * @param stu the stu to set
	 */
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	/**
	 * @return the link
	 */
	public StudentNode getLink() {
		return link;
	}
	
	/**
	 * @param link the link to set
	 */
	public void setLink(StudentNode link) {
		this.link = link;
	}
	
	/**
	 * This searches through all student nodes for the targeted student.
	 * @param head
	 * @param target
	 * @return
	 */
	public static Student searchStudent(StudentNode head, String target)
	   {
	      StudentNode cursor;
	      
	      for (cursor = head; cursor != null; cursor = cursor.link)
	         if (target.equalsIgnoreCase(cursor.stu.getId()))
	            return cursor.stu;
	        
	      return null;
	   }
}