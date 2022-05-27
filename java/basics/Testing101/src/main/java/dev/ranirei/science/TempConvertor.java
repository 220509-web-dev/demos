package dev.ranirei.science;

// convert any temp Celcius Farenheit Kelivin into any other type

public interface TempConvertor {

    double convert(String from, String to, double temp);

    double convert(TempType from, TempType to, double temp);


}
