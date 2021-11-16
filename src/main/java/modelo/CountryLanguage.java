/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author bryan
 */
public class CountryLanguage {
    String countryCode;
    String language;
    char isOfficial;
    float percentage;

    public CountryLanguage(String countryCode, String language, char isOfficial, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public char getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(char isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" + "countryCode=" + countryCode + ", language=" + language + ", isOfficial=" + isOfficial + ", percentage=" + percentage + '}';
    }
    
    
}
