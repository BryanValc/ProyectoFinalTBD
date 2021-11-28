package Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {

    @NonNull
    @PrimaryKey
    private String code;

    @NonNull
    @ColumnInfo(name="name")
    private String name;

    @NonNull
    @ColumnInfo(name="continent")
    private String continent;

    @NonNull
    @ColumnInfo(name="region")
    private String region;

    @NonNull
    @ColumnInfo(name="surfaceArea")
    private float surfaceArea;

    @NonNull
    @ColumnInfo(name="indepYear")
    private int indepYear;

    @NonNull
    @ColumnInfo(name="population")
    private int population;

    @NonNull
    @ColumnInfo(name="lifeExpectancy")
    private float lifeExpectancy;

    @NonNull
    @ColumnInfo(name="GNP")
    private float GNP;

    @NonNull
    @ColumnInfo(name="GNPOld")
    private float GNPOld;

    @NonNull
    @ColumnInfo(name="localName")
    private String localName;

    @NonNull
    @ColumnInfo(name="governmentForm")
    private String governmentForm;

    @NonNull
    @ColumnInfo(name="headOfState")
    private String headOfState;

    @NonNull
    @ColumnInfo(name="capital")
    private int capital;

    @NonNull
    @ColumnInfo(name="code2")
    private String code2;

    public Country(@NonNull String code, @NonNull String name, @NonNull String continent, @NonNull String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, @NonNull String localName, @NonNull String governmentForm, @NonNull String headOfState, int capital, @NonNull String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getContinent() {
        return continent;
    }

    public void setContinent(@NonNull String continent) {
        this.continent = continent;
    }

    @NonNull
    public String getRegion() {
        return region;
    }

    public void setRegion(@NonNull String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGNP() {
        return GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    @NonNull
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(@NonNull String localName) {
        this.localName = localName;
    }

    @NonNull
    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(@NonNull String governmentForm) {
        this.governmentForm = governmentForm;
    }

    @NonNull
    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(@NonNull String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    @NonNull
    public String getCode2() {
        return code2;
    }

    public void setCode2(@NonNull String code2) {
        this.code2 = code2;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", GNP=" + GNP +
                ", GNPOld=" + GNPOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }

}
