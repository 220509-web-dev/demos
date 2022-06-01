package dev.ranirei.science;

public class TempConvertorImpl implements  TempConvertor{

    @Override
    public double convert(String from, String to, double temp) {

        TempType t1 = TempType.Kelvin;
        if( from.equalsIgnoreCase("f")){
            t1 = TempType.Fahrenheit;
        }
        if( from.equalsIgnoreCase("c")){
            t1 = TempType.Celcius;
        }
        if( from.equalsIgnoreCase("k")){
            t1 = TempType.Kelvin;
        }

        TempType t2 = TempType.Kelvin;
        if( to.equalsIgnoreCase("f")){
            t2 = TempType.Fahrenheit;
        }
        if( to.equalsIgnoreCase("c")){
            t2 = TempType.Celcius;
        }
        if( to.equalsIgnoreCase("k")){
            t2 = TempType.Kelvin;
        }

        return this.convert(t1,t2,temp);
    }

    @Override
    public double convert(TempType from, TempType to, double temp) {

        String together = from.toString()+to.toString();

        if( from == TempType.Fahrenheit && temp < -457.59){
            throw  new AbsoluteZeroException();
        }

        if( from == TempType.Kelvin && temp < 0){
            throw  new AbsoluteZeroException();
        }

        if( from == TempType.Celcius && temp < -273.15){
            throw  new AbsoluteZeroException();
        }

        switch (together){

            case "CelciusFahrenheit":
                return (temp* 9/5) +32;

            case "CelciusKelvin":
                return temp + 273.15;

            case "FahrenheitCelcius":
                return (temp -32) *5/9;

            case "FahrenheitKelvin":
                return  (temp -32) *5/9 + 273.15;

            case "KelvinFahrenheit":
                return  (temp - 273.15) *9/5 +32;

            case "KelvinCelcius":
                return  temp - 273.15;

             default:
                 return temp;

        }

    }
}
