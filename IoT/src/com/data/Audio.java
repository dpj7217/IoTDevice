package com.data;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


public class Audio {
    private int ID = -1;
    private double duration;
    private double decibelamplitude;
    private double frequency;
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

    public double getAmplitude() { return this.decibelamplitude; }

    public double getFrequency() {
        return this.frequency;
    }


    public void setDuration(double newDuration) {
        this.duration = newDuration;
    }

    public void setDecibelAmplitude(double newAmplitude) {
        this.decibelamplitude = newAmplitude;
    }

    public void setFrequency(int newFrequency) {
        this.frequency = newFrequency;
    }


    public Audio(double Duration, double Amplitude, double Frequency) {
        this.duration = Duration;
        this.decibelamplitude = Amplitude;
        this.frequency = Frequency;
    }

    public Audio(int ID, double Duration, double Amplitude, double Frequency, Timestamp createdAt) {
        this.ID = ID;
        this.duration = Duration;
        this.decibelamplitude = Amplitude;
        this.frequency = Frequency;
        this.createdAt = createdAt;
    }

    public Audio() {
        this.duration = 0;
        this.decibelamplitude = 0;
        this.frequency = 0;
    }

    public String generateInsertSQL() {
        return "INSERT INTO sounds (duration, decibelamplitude, frequency) VALUES " + this.duration + ", " + this.decibelamplitude + ", " + this.frequency + ";";
    }


    public Map<String, Object> getParametersMap() {
        Map<String, Object> parameters = new HashMap<String, Object>();

        if (this.ID > 0) {
            parameters.put("ID", this.ID);
        }

        parameters.put("duration", this.duration);
        parameters.put("decibelamplitude", this.decibelamplitude);
        parameters.put("frequency", this.frequency);

        if (this.createdAt != null) {
            parameters.put("timestamp", this.createdAt);
        }


        return parameters;
    }

    public void insert() {
        DAO dao = new DAO();

        dao.Insert(this);
    }
    
    @Override
    public String toString() {
    	return "\nDuration: " + this.duration + "\nDecibelAmplitude: " + this.decibelamplitude + "\nFrequency: " + this.frequency + "\n";
    }
}
