package kr.kro.moonlightmoist.shopapi.soratest;

import lombok.Getter;

@Getter
public class Score {

    private int korea;
    private int math;
    private int eng;
    private String name;

    public Score(){};

    public Score(int korea, int math, int eng, String name){
        this.korea = korea;
        this.math = math;
        this.eng = eng;
        this.name = name;
    }
}
