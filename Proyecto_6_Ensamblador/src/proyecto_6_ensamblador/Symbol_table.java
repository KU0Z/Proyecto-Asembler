/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_6_ensamblador;

import java.util.Hashtable;

/**
 *
 * @author keviu
 */
public class Symbol_table {
    
    public Hashtable<String, Integer> ram = new Hashtable<String, Integer>();
    public Hashtable<String, Integer> rom = new Hashtable<String, Integer>();
    public Integer counterRam=16;
    public Symbol_table(){
        ram = new Hashtable<String, Integer>();
        rom = new Hashtable<String, Integer>();
        ram.put("R0",0);
        ram.put("R1",1);
        ram.put("R2",2);
        ram.put("R3",3);
        ram.put("R4",4);
        ram.put("R5",5);
        ram.put("R6",6);
        ram.put("R7",7);
        ram.put("R8",8);
        ram.put("R9",9);
        ram.put("R10",10);
        ram.put("R11",11);
        ram.put("R12",12);
        ram.put("R13",13);
        ram.put("R14",14);
        ram.put("R15",15);
        ram.put("SCREEN",16384);
        ram.put("KBD",24576);
        rom.put("SP",0);//SP, LCL, ARG, THIS, y THAT
        rom.put("LCL",1);
        rom.put("ARG",2);
        rom.put("THIS",3);
        rom.put("THAT",4);
    }
    
}
