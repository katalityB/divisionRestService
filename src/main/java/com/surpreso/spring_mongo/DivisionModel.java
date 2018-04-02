package com.surpreso.spring_mongo;

public class DivisionModel {
    private Double dividend, divisor, result;
    private String dividendStr, divisorStr, resultStr;

    public Double getDividend() {
        return dividend;
    }

    private void setDividend(Double dividend) {
        this.dividend = dividend;
    }

    public Double getDivisor() {
        return divisor;
    }

    private void setDivisor(Double divisor) {
        this.divisor = divisor;
    }

    public Double getResult() {
        return result;
    }

    private void setResult(Double result) {
        this.result = result;
    }

    public String getDividendStr() {
        return dividendStr;
    }

    public void setDividendStr(String dividendStr) {
        this.dividendStr = dividendStr;
    }

    public String getDivisorStr() {
        return divisorStr;
    }

    public void setDivisorStr(String divisorStr) {
        this.divisorStr = divisorStr;
    }

    public String getResultStr() {
        return resultStr;
    }

    private void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public DivisionModel(String dividendStr, String divisorStr) {
        this.dividend = Double.parseDouble(dividendStr);
        this.divisor = Double.parseDouble(divisorStr);
        this.result = PerformDivision();
        this.resultStr = result.toString();
    }

    private double PerformDivision() {
        return this.dividend / this.divisor;
    }
}