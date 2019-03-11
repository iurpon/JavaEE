package ru.trandefil.sc.model;

public class Session extends AbstractEntity {

    private long timestamp;

    private String userId;

    private Role role;

    private String signature;

    public Session(String id, long timestamp, String userId, Role role, String signature) {
        super(id);
        this.timestamp = timestamp;
        this.userId = userId;
        this.role = role;
        this.signature = signature;
    }

    public Session() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
