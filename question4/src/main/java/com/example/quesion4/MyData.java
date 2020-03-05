package com.example.quesion4;

class MyData {
    private String name;

    MyData(String name, String colorCode) {
        this.name = name;
        this.colorCode = colorCode;
    }

    private String colorCode;

    String getColorCode() {
        return colorCode;
    }

    String getName() {
        return name;
    }

}
