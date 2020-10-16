package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public abstract class WinterSportPlayer {
	private String name;
	private int age;

	public WinterSportPlayer() {}
	public WinterSportPlayer(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WinterSportPlayer that = (WinterSportPlayer) o;
		return age == that.age &&
				name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
