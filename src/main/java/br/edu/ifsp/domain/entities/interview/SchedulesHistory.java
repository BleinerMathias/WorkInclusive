package br.edu.ifsp.domain.entities.interview;

import java.time.LocalDateTime;

public class SchedulesHistory {
    private LocalDateTime suggestedIn;
    private LocalDateTime suggestedDate;

    public SchedulesHistory(LocalDateTime suggestedDate) {
        this.suggestedIn = LocalDateTime.from(LocalDateTime.now());
        this.suggestedDate = suggestedDate;
    }

    public LocalDateTime getSuggestedIn() {
        return suggestedIn;
    }

    public LocalDateTime getSuggestedDate() {
        return suggestedDate;
    }

    @Override
    public String toString() {
        return "SchedulesHistory{" +
                "suggestedIn=" + suggestedIn +
                ", suggestedDate=" + suggestedDate +
                '}';
    }
}
