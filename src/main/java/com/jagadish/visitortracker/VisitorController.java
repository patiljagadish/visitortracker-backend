package com.jagadish.visitortracker;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
public class VisitorController {

	@Autowired
    private VisitorRepository visitorRepository;

    @PostMapping("/visit")
    public Map<String, Object> recordVisit(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        Visitor visitor = new Visitor(ipAddress, LocalDateTime.now());
        visitorRepository.save(visitor);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Visit recorded");
        return response;
    }

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        long totalVisitors = visitorRepository.count();
        long uniqueVisitors = visitorRepository.countUniqueVisitors();

        Map<String, Object> response = new HashMap<>();
        response.put("totalVisitors", totalVisitors);
        response.put("uniqueVisitors", uniqueVisitors);
        return response;
    }
    
}
