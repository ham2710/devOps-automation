package com.to.repository.model;

public record CreateMusicianRequest(String firstName, String lastName, String email, int age) {
}