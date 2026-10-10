package object_detection.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detections")
public class Detection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objectName;

    private double confidence;

    private String detectedTime;

    public Detection() {
    }

    public Detection(String objectName, double confidence, String detectedTime) {
        this.objectName = objectName;
        this.confidence = confidence;
        this.detectedTime = detectedTime;
    }

    public Long getId() {
        return id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getDetectedTime() {
        return detectedTime;
    }

    public void setDetectedTime(String detectedTime) {
        this.detectedTime = detectedTime;
    }
}

