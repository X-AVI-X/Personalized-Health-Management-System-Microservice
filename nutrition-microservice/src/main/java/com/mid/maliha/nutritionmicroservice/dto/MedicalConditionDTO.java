package com.mid.maliha.nutritionmicroservice.dto;

public class MedicalConditionDTO {

    private Integer allergy;
    private Integer bpLow;
    private Integer bpHigh;

    public MedicalConditionDTO() {
    }

    public MedicalConditionDTO(Integer allergy, Integer bpLow, Integer bpHigh) {
        this.allergy = allergy;
        this.bpLow = bpLow;
        this.bpHigh = bpHigh;
    }

    public Integer getAllergy() {
        return allergy;
    }

    public void setAllergy(Integer allergy) {
        this.allergy = allergy;
    }

    public Integer getBpLow() {
        return bpLow;
    }

    public void setBpLow(Integer bpLow) {
        this.bpLow = bpLow;
    }

    public Integer getBpHigh() {
        return bpHigh;
    }

    public void setBpHigh(Integer bpHigh) {
        this.bpHigh = bpHigh;
    }
}
