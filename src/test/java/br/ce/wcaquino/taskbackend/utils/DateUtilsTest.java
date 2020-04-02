package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {
    @Test
    public void deveRetornaTrueParaDatasFuturas(){
        LocalDate date = LocalDate.of(2030, 03, 31);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
        System.out.println(DateUtils.isEqualOrFutureDate(date));
    }


    @Test
    public void deveRetornaFalseParaDatasPassadas(){
        LocalDate date = LocalDate.of(2020, 01, 01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
        System.out.println(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void deveRetornaTrueParaDatasAtual(){
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
        System.out.println(DateUtils.isEqualOrFutureDate(date));
    }

}
