package dev.ranieri.tests;

import dev.ranirei.science.AbsoluteZeroException;
import dev.ranirei.science.TempConvertor;
import dev.ranirei.science.TempConvertorImpl;
import dev.ranirei.science.TempType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TempConverterTests {

    static TempConvertor tempConvertor = new TempConvertorImpl();

    @Test
    public void convert_upper(){
        double f = tempConvertor.convert("C", "F", 0);
        Assertions.assertEquals(32,f);
    }

    @Test
    public void convert_lower(){
        double f = tempConvertor.convert("c", "f", 0);
        Assertions.assertEquals(32,f);
    }

    @Test
    public void convert_mixed_case(){
        double f = tempConvertor.convert("c", "F", 0);
        Assertions.assertEquals(32,f);
    }

    @Test
    public void convert_enums(){
        double f = tempConvertor.convert(TempType.Celcius, TempType.Fahrenheit, 0);
        Assertions.assertEquals(32,f);
    }

    @Test
    public void convert_enums2(){
        double f = tempConvertor.convert(TempType.Celcius, TempType.Fahrenheit, 100);
        Assertions.assertEquals(212,f);
    }

    @Test
    public void below_abolute_zero(){
        Assertions.assertThrows(AbsoluteZeroException.class, ()->{
            tempConvertor.convert("f","c", -2000);
        });
    }

    @Test
    public void same_temp(){
        double f = tempConvertor.convert(TempType.Celcius,TempType.Celcius, 200);
        Assertions.assertEquals(200,f);
    }


}
