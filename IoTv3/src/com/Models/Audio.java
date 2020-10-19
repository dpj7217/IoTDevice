package com.Models;

import java.sql.Timestamp;

public class Audio {
	private int ID = -1;
	private double duration;
    private double amplitude;
    private int frequency;
    private Timestamp createdAt = null;
    
    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public double getDuration() {
        return this.duration;
    }

    public double getAmplitude() {
        return this.amplitude;
    }

    public int getFrequency() {
        return this.frequency;
    }


    public void setDuration(double newDuration) {
        this.duration = newDuration;
    }

    public void setAmplitude(double newAmplitude) {
        this.amplitude = newAmplitude;
    }

    public void setFrequency(int newFrequency) {
        this.frequency = newFrequency;
    }

    public Audio(double Duration, double Amplitude, int Frequency) {
    	this.duration = Duration;
    	this.amplitude = Amplitude;
    	this.frequency = Frequency;
    }

    public Audio(int ID, double Duration, double Amplitude, int Frequency, Timestamp createdAt) {
    	this.ID = ID;
        this.duration = Duration;
        this.amplitude = Amplitude;
        this.frequency = Frequency;
        this.createdAt = createdAt;
    }
    
    public Audio() {
    	this.duration = 0;
    	this.amplitude = 0;
    	this.frequency = 0;
    }

    public String generateInsertSQL() {
        return "INSERT INTO sounds (duration, decibelamplitude, frequency) VALUES " + this.duration + ", " + this.amplitude + ", " + this.frequency + ";";
    }
}
