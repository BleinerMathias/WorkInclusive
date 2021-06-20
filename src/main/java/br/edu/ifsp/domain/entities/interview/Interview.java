package br.edu.ifsp.domain.entities.interview;
import java.time.LocalDateTime;


public class Interview {
    private LocalDateTime date;
    private LocalDateTime timeOfInterview;
    private String address;


    public Interview(LocalDateTime date, LocalDateTime timeOfInterview, String address) {
        this.date = date;
        this.timeOfInterview = timeOfInterview;
        this.address = address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getTimeOfInterview() {
        return timeOfInterview;
    }

    public void setTimeOfInterview(LocalDateTime timeOfInterview) {
        this.timeOfInterview = timeOfInterview;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "date=" + date +
                ", timeOfInterview=" + timeOfInterview +
                ", address='" + address + '\'' +
                '}';
    }
}
