package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double poc, kraj;
    boolean p, k;
    Interval(double poc, double kraj, boolean p, boolean k) {
        if (poc > kraj) {
            throw new IllegalArgumentException("Početna tačka veća od krajnje.");
        }
        this.poc=poc;
        this.kraj=kraj;
        this.p=p;
        this.k=k;
    }
    Interval(){
        this.poc=0;
        this.kraj=0;
        this.p=false;
        this.k=false;
    }
    public double getPoc() {
        return poc;
    }

    public double getKraj() {
        return kraj;
    }

    public boolean isP() {
        return p;
    }

    public boolean isK() {
        return k;
    }
    public void setPoc(double poc) {
        this.poc = poc;
    }

    public void setKraj(double kraj) {
        this.kraj = kraj;
    }

    public void setP(boolean p) {
        this.p = p;
    }

    public void setK(boolean k) {
        this.k = k;
    }
    boolean isNull(){
        if (poc==kraj) return true;
        return false;
    }
    boolean isIn(double x) {
        if ((this.isP()==false && (this.isK()==false && x > this.poc && x < this.kraj) || (this.isK()==true && x > this.poc && x <= this.kraj)) || (this.isP()==true && (this.isK()==false && x >= this.poc && x < this.kraj) || (this.isK()==true && x >= this.poc && x <= this.kraj)) ) return true;
        return false;
    }
    public Interval intersect (Interval interval) {
        Interval izlazni= new Interval();
        double p1=this.poc;
        double k1=this.kraj;
        double p2=interval.getPoc();
        double k2=interval.getKraj();
        if ((p1<p2 && k1<k2 && k1<p2) || (p2<p1 && k2<k1 && k2<p1)) {
            izlazni.setPoc(0);
            izlazni.setKraj(0);
        }
        if (p1<p2 && k1<k2 && p2<k1) {
            izlazni.setPoc(p2);
            izlazni.setKraj(k1);
            izlazni.setK(this.isK());
            izlazni.setP(interval.isP());
        }
        if (p1<p2 && k1>k2) {
            izlazni.setPoc(p2);
            izlazni.setKraj(k2);
            izlazni.setK(interval.isK());
            izlazni.setP(interval.isP());
        }
        if (p2<p1 && k2<k1 && p1<k2) {
            izlazni.setPoc(p1);
            izlazni.setKraj(k2);
            izlazni.setK(interval.isK());
            izlazni.setP(this.isP());
        }
        if (p2<p1 && k1<k2) {
            izlazni.setPoc(p1);
            izlazni.setKraj(k1);
            izlazni.setK(this.isK());
            izlazni.setP(this.isP());
        }
        return izlazni;
    }
    public static Interval intersect (Interval interval1, Interval interval2) {
        Interval izlazni= new Interval();
        double p1= interval1.getPoc();
        double p2= interval2.getPoc();
        double k1= interval1.getKraj();
        double k2= interval2.getKraj();
        if ((p1<p2 && k1<k2 && k1<p2) || (p2<p1 && k2<k1 && k2<p1)) {
            izlazni.setPoc(0);
            izlazni.setKraj(0);
        }
        if (p1<p2 && k1<k2 && p2<k1) {
            izlazni.setPoc(p2);
            izlazni.setKraj(k1);
            izlazni.setK(interval1.isK());
            izlazni.setP(interval2.isP());
        }
        if (p1<p2 && k1>k2) {
            izlazni.setPoc(p2);
            izlazni.setKraj(k2);
            izlazni.setK(interval2.isK());
            izlazni.setP(interval2.isP());
        }
        if (p2<p1 && k2<k1 && p1<k2) {
            izlazni.setPoc(1);
            izlazni.setKraj(2);
            izlazni.setK(interval2.isK());
            izlazni.setP(interval1.isP());
        }
        if (p2<p1 && k1<k2) {
            izlazni.setPoc(p1);
            izlazni.setKraj(k1);
            izlazni.setK(interval1.isK());
            izlazni.setP(interval1.isP());
        }
        return izlazni;
    }
    @Override
    public String toString() {
        String sting;
        if (this.isNull()) return "()";
        if (this.isP()==true) sting="[";
        else sting="(";
        sting=sting+this.getPoc();
        sting=sting+",";
        sting=sting+this.getKraj();
        if (this.isK()==true) sting=sting+"]";
        else sting=sting+")";
        return sting;
    }
    @Override
    public boolean equals(Object o) {
        Interval i = (Interval) o;
        if (this.getPoc()==i.getPoc() && this.getKraj()==i.getKraj() && this.isP()==i.isP() && this.isK()==i.isK()) return true;
        return false;
    }
}