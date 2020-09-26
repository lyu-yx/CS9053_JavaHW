package assignment3.part1;

public class Holiday {
	private String name;
	private int day;
	private String month;

	public Holiday() {

    }

	public Holiday(String name, int day, String month) {
	    this.name = name;
	    this.day = day;
	    this.month = month;
    }

    public static boolean inSameMonth(Holiday firstHoliday, Holiday secondHoliday) {
	    return firstHoliday.month == secondHoliday.month;
    }

    public static double avgDate(Holiday[] holidays) {
	    double sum = 0;
	    int length = holidays.length;
	    for (Holiday holiday : holidays) {
            sum += holiday.day;
        }
	    return sum / length;
    }

// Setters & Getters
    public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return this.month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return this.day;
	}
	public void setDay(int day) {
		this.day = day;
	}

	//toString
	public String toString() {
		return name + ":" + month + " " + day;
	}

    public static void main(String[] args) {

		Holiday[] holidays = new Holiday[2];
		holidays[0] = new Holiday("Independence Day", 4, "July");
		holidays[1] = new Holiday("Christmas Day", 25, "December");
		System.out.println("holidays[0] and holidays[1] are same holiday: " + inSameMonth(holidays[0], holidays[1]));
		System.out.println("The average date of holidays is: " + avgDate(holidays));
		System.out.println(holidays[0].toString());
	}
}
