package com.jagadish.visitortracker;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visitor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private LocalDateTime visitTime;

    // Constructors
    public Visitor() {
    	
    }
    
    public Visitor(String ipAddress, LocalDateTime visitTime) {
        this.ipAddress = ipAddress;
        this.visitTime = visitTime;
    }

    // Getters and Setters
    public Long getId() { 
    	return id; 
    }
    
    public String getIpAddress() { 
    	return ipAddress; 
    }
    
    public void setIpAddress(String ipAddress) { 
    	this.ipAddress = ipAddress; 
    }
    
    public LocalDateTime getVisitTime() { 
    	return visitTime; 
    }
    
    public void setVisitTime(LocalDateTime visitTime) { 
    	this.visitTime = visitTime; 
    }
	
}
