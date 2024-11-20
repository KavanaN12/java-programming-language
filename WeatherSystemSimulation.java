import java.util.ArrayList;
import java.util.Scanner;

class WeatherData {
    String cityName;
    double temperature;
    int humidity;
    double windSpeed;

    public WeatherData(String cityName, double temperature, int humidity, double windSpeed) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public void updateWeatherData(double temperature, int humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getWeatherDetails() {
        return "\nCity: " + cityName.toUpperCase() + "\nTemperature: " + temperature + "\nHumidity: " + humidity
                + "\nWind Speed: "
                + windSpeed + "\n";
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}

class WeatherMonitor {
    static ArrayList<WeatherData> weather = new ArrayList<WeatherData>();
    int m = 0;

    public void addWeatherData(WeatherData weatherData) {
        updateCityWeather(weatherData.cityName, weatherData.temperature, weatherData.humidity, weatherData.windSpeed);
    }

    public void updateCityWeather(String cityName, double temperature, int humidity, double windSpeed) {
        WeatherData w = new WeatherData(cityName, temperature, humidity, windSpeed);
        boolean index = false;
        for (int i = 0; i < weather.size(); i++) {
            if (weather.get(i).cityName.equals(cityName)) {
                weather.get(i).updateWeatherData(temperature, humidity, windSpeed);
                index = true;
                break;
            }
        }
        if (index == false) {
            System.out.println("Adding details of " + cityName.toUpperCase());
            weather.add(w);
        }
    }

    public void generateReport() {
        String maxcity;
        double temp = 0;
        int humd = 70;
        double windspd = 0;
        ArrayList<String> humdcity = new ArrayList<String>();
        int max = 0;
        for (int i = 0; i < weather.size(); i++) {
            temp += weather.get(i).temperature;
            if (weather.get(i).windSpeed > weather.get(max).windSpeed) {
                max = i;
            }
            if (weather.get(i).humidity > humd) {
                humdcity.add(weather.get(i).cityName);
            }
        }
        temp = temp / weather.size();
        windspd = weather.get(max).windSpeed;
        maxcity = weather.get(max).cityName;

        System.out.print("\nAverage Temperature throughout the country: ");
        System.out.format("%.2f", temp);
        System.out.println("\nMaximum wind speed recorded: "
                + windspd
                + "\tin the City: " + maxcity.toUpperCase()
                + "\nThe following cities have humidity more than threshold value");
        for (int i = 0; i < humdcity.size(); i++) {
            System.out.println(humdcity.get(i).toUpperCase());
        }
        System.out.println();
    }

    public void getCityWeather(String cityName) {
        for (int i = 0; i < weather.size(); i++) {
            if (weather.get(i).cityName.equals(cityName)) {
                System.out.println(weather.get(i).getWeatherDetails());
            }
        }
    }
}

public class WeatherSystemSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String link;
        WeatherData w1 = new WeatherData("banglore", 310.05, 67, 23.6);
        WeatherData w2 = new WeatherData("mumbai", 288.05, 79, 28.6);
        WeatherData w3 = new WeatherData("hyderabad", 298.05, 74, 27.6);
        WeatherData w4 = new WeatherData("chennai", 312.05, 68, 24.6);
        WeatherData w5 = new WeatherData("delhi", 300.05, 69, 21.6);
        WeatherData w6 = new WeatherData("chandigarh", 317.05, 70, 20.6);
        WeatherMonitor m1 = new WeatherMonitor();
        m1.addWeatherData(w1);
        m1.addWeatherData(w2);
        m1.addWeatherData(w3);
        m1.addWeatherData(w4);
        m1.addWeatherData(w5);
        m1.addWeatherData(w6);
        int k = 0;
        while (k < 1) {
            System.out.println(
                    "Do you want to add weather data for a city,Enter 1\nDo you want to update existing weather data for a city,Enter 2\nEnter 3 to quit");
            int key = sc.nextInt();
            if (key == 1 || key == 2) {
                System.out.println("Enter the cityname,temperature,humidity,windspeed");
                String cityName = sc.next().toLowerCase();
                double temperature = sc.nextDouble();
                int humidity = sc.nextInt();
                double windSpeed = sc.nextDouble();
                WeatherData w7 = new WeatherData(cityName, temperature, humidity, windSpeed);
                m1.addWeatherData(w7);
            }
            System.out.println("Do you want to check weather of any specific city,Yes/No");
            link = sc.next();
            if (link.toLowerCase().equals("yes")) {
                System.out.println("Enter the city name:");
                m1.getCityWeather(sc.next().toLowerCase());
            }
            m1.generateReport();
        }
        sc.close();
    }
}
