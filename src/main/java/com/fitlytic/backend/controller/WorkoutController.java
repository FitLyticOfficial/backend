package com.fitlytic.backend.controller;

import com.fitlytic.backend.model.Workout;
import com.fitlytic.backend.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // POST /api/workouts
    @PostMapping
    public ResponseEntity<Workout> logWorkout(@RequestBody Workout workout) {
        workout.setDate(LocalDateTime.now()); // set current date/time
        // Simulate logged-in user
        workout.setUser(null); // Will replace with actual user from JWT later
        return ResponseEntity.ok(workoutService.logWorkout(workout));
    }

    // GET /api/workouts/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getWorkouts(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutService.getWorkoutsByUserId(userId));
    }
}
