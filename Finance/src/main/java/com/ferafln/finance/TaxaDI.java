/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.finance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author INDRA
 */
@Data
@AllArgsConstructor
public class TaxaDI {
    private BigDecimal taxaAA;
    private LocalDate startDate;
    private LocalDate endDate;
    private final Set<DayOfWeek> businessDays = Set.of(
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    );

    public TaxaDI(BigDecimal taxaAA, LocalDate startDate) {
        this.taxaAA = taxaAA;
        this.startDate = startDate;
    }


    
    public BigDecimal getTaxaAD(){
        int totalOfDays = getWorkDaysOfYear(tmpEndDate().getYear());
        return taxaAA.divide(BigDecimal.valueOf(totalOfDays), 10, RoundingMode.HALF_UP);
    }
    
    public BigDecimal getAcumulado(){
        retu
    }
    
    private LocalDate tmpEndDate(){
        return this.endDate == null ? LocalDate.now() : this.endDate;
    } 
    
    
    private int getWorkDaysOfYear(LocalDate startDate, LocalDate endDate){
        return startDate
            .datesUntil(endDate)
            .filter(d-> businessDays.contains(d.getDayOfWeek()))
            .collect(Collectors.toList())
            .size()+1;
    }
    
    private int getWorkDaysOfYear(int year){
        return LocalDate
            .of(year, Month.JANUARY, 1)
            .datesUntil(LocalDate.of(year, Month.DECEMBER, 31))
            .filter(d-> businessDays.contains(d.getDayOfWeek()))
            .collect(Collectors.toList())
            .size()+1;
    }
    public static void main(String[] args) {
        TaxaDI tx = new TaxaDI(BigDecimal.valueOf(0.01933), LocalDate.of(2021, Month.AUGUST, 6));
        System.out.println(tx.getTaxaAD());
        
        
    }
}
