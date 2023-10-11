package org.example.model;

public class FindColumnInfo {
    String name;
    int index;
    String dataType;

    public FindColumnInfo(String name, int index, String dataType) {
        this.name = name;
        this.index = index;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
