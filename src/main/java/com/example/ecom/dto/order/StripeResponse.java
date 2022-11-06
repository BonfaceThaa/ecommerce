package com.example.ecom.dto.order;

public class StripeResponse {
    private String sessionId;

    public StripeResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    public StripeResponse() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
