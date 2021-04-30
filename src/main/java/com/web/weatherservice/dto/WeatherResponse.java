package com.web.weatherservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponse {
	private Coord coord;
	private List<Weather> weather;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Sys sys;
	private Root root;
}

@Data
class Coord {
	private double lon;
	private double lat;
}

@Data
class Weather {
	private int id;
	private String main;
	private String description;
	private String icon;
}

@Data
class Main {
	private double temp;
	private int pressure;
	private int humidity;
	private double temp_min;
	private double temp_max;
}

@Data
class Wind {
	private double speed;
	private int deg;
}

@Data
class Clouds {
	private int all;
}

@Data
class Sys {
	private int type;
	private int id;
	private double message;
	private String country;
	private int sunrise;
	private int sunset;
}

@Data
class Root {
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private Sys sys;
	private int id;
	private String name;
	private int cod;
}
