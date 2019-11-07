package dmacc.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "exercise")
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long exerciseid;
	private String exercisetype;
	private int sets;
	private int reps;
	private Date date;
	
	public Exercise() {
		
	}
	
	//getters and setters
	public long getExerciseid() {
		return exerciseid;
	}
	public void setExerciseid(long exerciseid) {
		this.exerciseid = exerciseid;
	}
	public String getExercisetype() {
		return exercisetype;
	}
	public void setExercisetype(String exercisetype) {
		this.exercisetype = exercisetype;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//to string
	@Override
	public String toString() {
		return "Exercise [exerciseid=" + exerciseid + ", exercisetype=" + exercisetype + ", sets=" + sets + ", reps="
				+ reps + ", date=" + date + "]";
	}
	
	

}
