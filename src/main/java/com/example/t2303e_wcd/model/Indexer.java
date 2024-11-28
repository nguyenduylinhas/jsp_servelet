package com.example.t2303e_wcd.model;

public class Indexer {
    private int indexId;
    private String name;
    private float valueMin;
    private float valueMax;

    public Indexer(int indexId, String name, float valueMin, float valueMax) {
        this.indexId = indexId;
        this.name = name;
        this.valueMin = valueMin;
        this.valueMax = valueMax;
    }

    public int getIndexId() { return indexId; }
    public String getName() { return name; }
    public float getValueMin() { return valueMin; }
    public float getValueMax() { return valueMax; }

    public void setIndexId(int indexId) { this.indexId = indexId; }
    public void setName(String name) { this.name = name; }
    public void setValueMin(float valueMin) { this.valueMin = valueMin; }
    public void setValueMax(float valueMax) { this.valueMax = valueMax; }
}
