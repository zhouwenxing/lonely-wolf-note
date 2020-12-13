package com.lonely.wolf.note.design.pattern.observe.headfirst;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class TestWeather {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();//气象数据即被观察者
        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherData);//天气展示即观察者
        weatherData.setMessurements(37.2f,80f,32.5f);
        weatherDisplay.display();//天气展示
    }
}
