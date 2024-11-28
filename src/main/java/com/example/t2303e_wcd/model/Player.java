package com.example.t2303e_wcd.model;

public class Player {
    private int playerId;
    private String name;
    private String fullName;
    private String age;
    private int indexId;
    private String indexName; // Optional, for displaying index details in the UI

    public Player(int playerId, String name, String fullName, String age, int indexId, String indexName) {
        this.playerId = playerId;
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.indexId = indexId;
        this.indexName = indexName;
    }

    public Player(String name, String fullName, String age, int indexId) {
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.indexId = indexId;
    }

    public Player(int id, String name, String fullName, String age, int indexId) {
    }

    public int getPlayerId() { return playerId; }
    public String getName() { return name; }
    public String getFullName() { return fullName; }
    public String getAge() { return age; }
    public int getIndexId() { return indexId; }
    public String getIndexName() { return indexName; }

    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public void setName(String name) { this.name = name; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setAge(String age) { this.age = age; }
    public void setIndexId(int indexId) { this.indexId = indexId; }
    public void setIndexName(String indexName) { this.indexName = indexName; }
}
