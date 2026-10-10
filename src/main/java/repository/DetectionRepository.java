package object_detection.repository;

import object_detection.entity.Detection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectionRepository
        extends JpaRepository<Detection, Long> {
}

