package ie.gmit.shellieflo.womansapp;

import java.io.Serializable;

/**
 * Created by shellieflo on 23/04/2015.
 */
public class BodyMetrics implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private static String name;
    private static double weight;
    private static double height;
    private static int age;
    private static double hips;
    private static double waist;
    public static double bmi;
    public static double fat;
    public static double mass;
    public static double ratio;

    public BodyMetrics(long id, String name, double weight, double height, int age, double waist, double hips, double bmi, double fat, double leanmass, double ratio) {
        super();
        this.id = id;
        BodyMetrics.name = name;
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
        BodyMetrics.age = age;
        BodyMetrics.waist = waist;
        BodyMetrics.hips = hips;
        BodyMetrics.bmi =getBmi();
        fat = getBodyfat();
        leanmass= getLeanMass();
        ratio = getRatio();
    }

    public BodyMetrics(String name, double weight, double height, int age, double waist, double hips) {
        super();
        BodyMetrics.name = name;
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
        BodyMetrics.age = age;
        BodyMetrics.waist = waist;
        BodyMetrics.hips = hips;
    }


//    public BodyMetrics( String name, double weight, double height, int age, double waist,
//                        double hips,double bmi,double bodyfat,double leanmass,double ratio) {
//        super();
//        BodyMetrics.name = name;
//        BodyMetrics.weight = weight;
//        BodyMetrics.height = height;
//        BodyMetrics.age = age;
//        BodyMetrics.waist = waist;
//        BodyMetrics.hips = hips;
//        BodyMetrics.bmi =getBmi();
//        bodyfat = getBodyfat();
//        leanmass= getLeanMass();
//        ratio = getRatio();
//    }


    public BodyMetrics(String name, double weight, double height, double waist, double hips) {
        super();
        BodyMetrics.name = name;
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
        BodyMetrics.waist = waist;
        BodyMetrics.hips = hips;
    }

    public BodyMetrics(String name, double weight, double height, double waist) {
        super();
        BodyMetrics.name = name;
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
        BodyMetrics.waist = waist;
    }

    public BodyMetrics(String name, double weight, double height) {
        super();
        BodyMetrics.name = name;
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
    }

    public BodyMetrics(double weight, double height) {
        super();
        BodyMetrics.weight = weight;
        BodyMetrics.height = height;
    }

    public BodyMetrics(long id, String name, double weight, double height, int age, double waist, double hips, SQLiteMetricsDatabaseHelper sqLiteMetricsDatabaseHelper) {
    }

    public double getbmi() {
        return bmi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        BodyMetrics.name = name;
    }

    public String getName() {
        return name;
    }


    public void setWeight(double weight) {
        BodyMetrics.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        BodyMetrics.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWaist(double waist) {
        BodyMetrics.waist = waist;
    }

    public double getWaist() {
        return waist;
    }

    public void setHips(double hips) {
        BodyMetrics.hips = hips;
    }

    public double getHips() {
        return hips;
    }

    public void setAge(int age) {
        BodyMetrics.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setBmi(double height) {
        bmi = weight / (height * height);
    }

    public  double getBmi() {
        return bmi;
    }

    public void setBodyfat(String string) {
        fat = ((bmi * 1.2) + (age * 0.23 * -5.4));
    }

    public double getBodyfat() {
        return fat;
    }


    public void setLeanMass(double weight) {
        mass = weight - (weight * fat);
    }

    public double getLeanMass() {
        return mass;
    }

    public void setRatio(double waist) {
        double ratio = waist / hips;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "BodyMetrics{" +
                "id=" + id +
                '}';
    }



}
