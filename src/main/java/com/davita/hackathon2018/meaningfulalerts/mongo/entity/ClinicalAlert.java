package com.davita.hackathon2018.meaningfulalerts.mongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "patientalerts")
public class ClinicalAlert {

    @Id
    private String id;

    private String patientName;

    private Long physicianId;

    private String value;

    private String alertName;

    private String alertCategory;

    // will say positive/negative/low/high/mvp
    private String output;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date alertDate;

    public ClinicalAlert(String id) {
        this.id = id;
    }

    public ClinicalAlert() {
    }

    public ClinicalAlert(String id, String patientName, Long physicianId, String value, String alertName, String alertCategory, String output, Date alertDate) {
        this.id = id;
        this.patientName = patientName;
        this.physicianId = physicianId;
        this.value = value;
        this.alertName = alertName;
        this.alertCategory = alertCategory;
        this.output = output;
        this.alertDate = alertDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId) {
        this.physicianId = physicianId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    public String getAlertCategory() {
        return alertCategory;
    }

    public void setAlertCategory(String alertCategory) {
        this.alertCategory = alertCategory;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    @Override
    public String toString() {
        return "ClinicalAlert{" +
                "id='" + id + '\'' +
                ", patientName='" + patientName + '\'' +
                ", physicianId=" + physicianId +
                ", value='" + value + '\'' +
                ", alertName='" + alertName + '\'' +
                ", alertCategory='" + alertCategory + '\'' +
                ", output='" + output + '\'' +
                ", alertDate=" + alertDate +
                '}';
    }
}
