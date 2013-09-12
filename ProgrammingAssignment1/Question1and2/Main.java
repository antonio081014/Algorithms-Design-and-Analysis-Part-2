import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author antonio081014
 * @time Sep 11, 2013, 10:01:40 PM
 */
public class Main {

	private Job[] jobList;
	private int jobLen;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("jobs.txt"));
			jobLen = Integer.parseInt(in.readLine());
			jobList = new Job[jobLen];
			for (int i = 0; i < jobLen; i++) {
				String[] s = in.readLine().split("\\s");
				long w = Long.parseLong(s[0]);
				long l = Long.parseLong(s[1]);
				jobList[i] = new Job(w, l);
			}
			in.close();
			System.out.println(greedy_diff(jobList.clone()));
			System.out.println(greedy_ratio(jobList.clone()));
		} catch (Exception e) {
		}
	}

	/**
	 * Answer: 69119377652;
	 * */
	private long greedy_diff(Job[] jobList) {
		Arrays.sort(jobList, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				long diff1 = j1.getWeight() - j1.getLength();
				long diff2 = j2.getWeight() - j2.getLength();
				if (diff1 < diff2)
					return 1;
				else if (diff1 > diff2)
					return -1;
				else {
					if (j1.getWeight() > j2.getWeight())
						return -1;
					else if (j1.getWeight() < j2.getWeight())
						return 1;
					else
						return 0;
				}
			}
		});
		long finish = 0;
		long sum = 0;
		for (int i = 0; i < jobLen; i++) {
			finish += jobList[i].getLength();
			sum += finish * jobList[i].getWeight();
		}
		return sum;
	}

	/**
	 * Answer: 67311454237;
	 * */
	private long greedy_ratio(Job[] jobList) {
		Arrays.sort(jobList, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				long r1 = j1.getWeight() * j2.getLength();
				long r2 = j2.getWeight() * j1.getLength();
				if (r1 > r2)
					return -1;
				else if (r1 < r2)
					return 1;
				return 0;
			}
		});
		long finish = 0;
		long sum = 0;
		for (int i = 0; i < jobLen; i++) {
			finish += jobList[i].getLength();
			sum += finish * jobList[i].getWeight();
		}
		return sum;
	}
}
