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
import ua_parser.Client;
import ua_parser.Parser;

@RestController
@CrossOrigin(origins = "*")
public class VisitorController {

	@Autowired
    private VisitorRepository visitorRepository;

    @PostMapping("/visit")
    public Map<String, Object> recordVisit(HttpServletRequest request) {

    	//        	String ipAddress = request.getRemoteAddr();
        String ipAddress = extractClientIp(request);
        
        String userAgentString = request.getHeader("User-Agent");
        
        Parser uaParser = new Parser();
        Client client = uaParser.parse(userAgentString);
        String browser = client.userAgent.family;
        String os = client.os.family;
        
        Visitor visitor = new Visitor(ipAddress, LocalDateTime.now(), browser, os);
        visitorRepository.save(visitor);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Visit recorded");
        return response;
    }
    
    private String extractClientIp(HttpServletRequest request) {
        String header = request.getHeader("X-Forwarded-For");
        if (header != null && !header.isEmpty()) {
            return header.split(",")[0].trim();
        }
        return request.getRemoteAddr();
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
