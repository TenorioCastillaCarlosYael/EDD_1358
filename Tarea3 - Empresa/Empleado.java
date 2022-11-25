package com.urbenia.arreglos_adt;

/**
 *
 * @author yael_
 */
public class Empleado {
    
    public static void main(String[] args) {
        Empleado Nuevo = new Empleado(19, "Carlos Yael", "Tenorio", "Castilla", 0, 9850, 2017);
        System.out.println(Nuevo.to_String());
        System.out.println("--|-|-|-|--");
        System.out.println(Nuevo.CalcularSueldo());
    }

    private int NumTrabajador;
    private String Nombres;
    private String Ap_Paterno;
    private String Ap_Materno;
    private int Horas_Ex;
    private int Sueldo_B;
    private int Año_Ing;
    private int Ant;
    private double Tolat;
    double PagHE = 275.5;

    public Empleado(int NT, String Nom, String Ap_P, String Ap_M, int H_E, int S_B, int Año_Ing) {
        this.NumTrabajador = NT;
        this.Nombres = Nom;
        this.Ap_Paterno = Ap_P;
        this.Ap_Materno = Ap_M;
        this.Horas_Ex = H_E;
        this.Sueldo_B = S_B;
        this.Año_Ing = Año_Ing;
    }

    public int get_NumTrabajador() {
        return this.NumTrabajador;
    }

    public void set_NumTrabajador(int NT) {
        this.NumTrabajador = NT;
    }

    public String get_Nombres() {
        return this.Nombres;
    }

    public void set_Nombres(String Nom) {
        this.Nombres = Nom;
    }

    public String get_ApellidoP() {
        return this.Ap_Paterno;
    }

    public void set_ApellidoP(String Ap_P) {
        this.Ap_Paterno = Ap_P;
    }

    public String get_ApellidoM() {
        return this.Ap_Materno;
    }

    public void set_ApellidoM(String Ap_M) {
        this.Ap_Materno = Ap_M;
    }

    public int get_HorasExtra() {
        return this.Horas_Ex;
    }

    public void set_HorasExtra(int H_E) {
        this.Horas_Ex = H_E;
    }

    public int get_SueldoBase() {
        return this.Sueldo_B;
    }

    public void set_SueldoBase(int S_B) {
        this.Sueldo_B = S_B;
    }

    public int get_AñoIngreso() {
        return this.Año_Ing;
    }

    public void set_AñoIngreso(int Año_Ing) {
        this.Año_Ing = Año_Ing;
    }

    public String to_String() { //Stan es estado en polaco.
        String Stan = "";
        Stan += NumTrabajador + "\n";
        Stan += Nombres + "\n";
        Stan += Ap_Paterno + "\n";
        Stan += Ap_Materno + "\n";
        Stan += Horas_Ex + "\n";
        Stan += Sueldo_B + "\n";
        Stan += Año_Ing;
        return Stan;
    }

    public double CalcularSueldo() {
        Ant = 2022 - this.Año_Ing;
        Tolat = this.Sueldo_B + (this.Sueldo_B * (Ant * 0.03)) + this.Horas_Ex * PagHE;
        return Tolat;
    }
}
