package com.mid.mentalhealthmicroservice.dto;

public class QuestionsDTO {
    private Integer sleep;
    private Integer stress;
    private Integer anxiety;

    public QuestionsDTO(Integer sleep, Integer stress, Integer anxiety) {
        this.sleep = sleep;
        this.stress = stress;
        this.anxiety = anxiety;
    }

    public QuestionsDTO() {
    }

    public Integer getSleep() {
        return sleep;
    }

    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    public Integer getStress() {
        return stress;
    }

    public void setStress(Integer stress) {
        this.stress = stress;
    }

    public Integer getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(Integer anxiety) {
        this.anxiety = anxiety;
    }
}
