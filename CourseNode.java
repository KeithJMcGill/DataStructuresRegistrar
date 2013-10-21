/**
 * This is the CourseNode class. It holds the nodes for the courses.
 * @author Keith McGill
 * @version 12/6/12
 */
public class CourseNode
{
	public Course cou;
	public CourseNode link;
	
	/**
	 * This is the constructor for the class. It initializes a link.
	 * @param initialCOU
	 * @param initialLink
	 */
	public CourseNode(Course initialCOU, CourseNode initialLink)
	{
		cou = initialCOU;
		link = initialLink;
	}

	/**
	 * @return the cou
	 */
	public Course getCou() {
		return cou;
	}

	/**
	 * @param cou the cou to set
	 */
	public void setCou(Course cou) {
		this.cou = cou;
	}

	/**
	 * @return the link
	 */
	public CourseNode getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(CourseNode link) {
		this.link = link;
	}
	
	/**
	 * This searches through all course nodes for the targeted course.
	 * @param head
	 * @param target
	 * @return
	 */
	public static Course searchCourse(CourseNode head, String target)
	   {
	      CourseNode cursor;
	      
	      for (cursor = head; cursor != null; cursor = cursor.link)
	         if (target.equalsIgnoreCase(cursor.cou.getCrn()))
	            return cursor.cou;
	        
	      return null;
	   }
}