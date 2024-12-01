package com.user.model;

public class user {
    private int memberId;
    private String name;
    private String email;
    private String membershipId;
    private String passwordHash;
    private String country;

    // Constructor
    public user(int memberId, String name, String email, String membershipId, String passwordHash, String country) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.membershipId = membershipId;
        this.passwordHash = passwordHash;
        this.country = country;
    }

    // Getters and Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Method to display user details
    public void displayUserDetails() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Country: " + country);
    }

    // Method to update profile details
    public void updateProfile(String newName, String newEmail, String newPasswordHash, String newCountry) {
        this.name = newName;
        this.email = newEmail;
        this.passwordHash = newPasswordHash;
        this.country = newCountry;
        System.out.println("Profile updated successfully.");
    }

    // Override toString method
    @Override
    public String toString() {
        return "User{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", membershipId='" + membershipId + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
