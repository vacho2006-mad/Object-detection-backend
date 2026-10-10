package object_detection.controller;

import object_detection.entity.Detection;
import object_detection.repository.DetectionRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detection")
@CrossOrigin(origins = "*")
public class DetectionController {

    private final DetectionRepository repository;

    public DetectionController(DetectionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public Detection addDetection(
            @RequestBody Detection detection) {

        return repository.save(detection);
    }

    @GetMapping("/all")
    public List<Detection> getAllDetections() {

        return repository.findAll();
    }

    @DeleteMapping("/clear")
    public String clearHistory() {

        repository.deleteAll();

        return "Detection history cleared";
    }
}
