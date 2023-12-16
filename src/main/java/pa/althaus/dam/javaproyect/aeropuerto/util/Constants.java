package pa.althaus.dam.javaproyect.aeropuerto.util;

import java.text.SimpleDateFormat;

public class Constants {
    // Weekdays
    public static final String MONDAY = "L";
    public static final String TUESDAY = "M";
    public static final String WEDNESDAY = "X";
    public static final String THURSDAY = "J";
    public static final String FRIDAY = "V";
    public static final String SATURDAY = "S";
    public static final String SUNDAY = "D";

    // Paths
    public static final String PATH_DAILYFLIGHT = "pa/althaus/dam/javaproyect/aeropuerto/model/data/DailyFlight.csv";
    public static final String PATH_FLIGHT = "pa/althaus/dam/javaproyect/aeropuerto/model/data/Flight.csv";
    public static final String PATH_AIRPORTS = "pa/althaus/dam/javaproyect/aeropuerto/model/data/Airport.csv";
    public static final String PATH_AIRLINECOMPANY = "pa/althaus/dam/javaproyect/aeropuerto/model/data/AirlineCompany.csv";
    public static final String PATH_MUNICIPIOS = "aeropuerto/resources/Municipios.csv";

    // Date Formats
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    // Frame Dimensions
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
}
