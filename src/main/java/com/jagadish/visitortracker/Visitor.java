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
    
    private String browser;
    private String os;

    // Constructors
    public Visitor() {
    	
    }
    
    public Visitor(String ipAddress, LocalDateTime visitTime, String browser, String os) {
        this.ipAddress = ipAddress;
        this.visitTime = visitTime;
        this.browser = browser;
        this.os = os;
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

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setId(Long id) {
		this.id = id;
	}
	    
}
