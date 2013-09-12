/**
 * 
 */

/**
 * @author antonio081014
 * @time Sep 11, 2013, 10:03:23 PM
 */
public class Job {

	private long weight;
	private long length;

	public Job(long w, long l) {
		weight = w;
		length = l;
	}

	/**
	 * @return the weight
	 */
	public long getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(long weight) {
		this.weight = weight;
	}

	/**
	 * @return the length
	 */
	public long getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(long length) {
		this.length = length;
	}

}
