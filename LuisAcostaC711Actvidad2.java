package com.mycompany.luisacosta;
import java.util.Scanner;

/**
*
* @author Luis Acosta : 30139928    ->  Corte I - Actividad II
* 
* 
* Elaborar un programa que permita obtener la nómina semanal —salario neto— de n trabajadores de una empresa, cuyo trabajo se paga por horas y del modo siguiente:
*
*las horas inferiores o iguales a 35 horas (normales) se pagan a una tarifa determinada, que se debe introducir por teclado, al igual que el número de horas y el nombre del trabajador,
*las horas superiores a 35 se pagarán como horas extra, con un incremento del 50% sobre la tarifa para las horas normales,
*los impuestos a deducir a los trabajadores varían en función de su sueldo:
* 
* 
*    sueldo <= 2.000, libre de impuestos,
*    el resto, al 20 por 100.
*   Por trabajador, la salida debe presentar: 
*   Cantidad Horas Normales
*   Tarifa HN
*   Ingreso HN
*    Cantidad Horas Extra (si aplica)
*    Tarifa HE (si aplica)
*    Ingreso HE (si aplica)
*    Total Salario Bruto
*    Deducción por Impuesto (si aplica)
*    Total Salario Neto
* 
*/
public class LuisAcostaC711Actvidad2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int Cantidad, contadorWhile = 0, contadorR = 1;

        System.out.print("Cantidad maxima de registros: ");
        Cantidad = entrada.nextInt();

        //datos predeterminados
            int horasN = 35;
            int impuestos = 2000;

        //Arrays para los datos de emplados
                                    String[] nombres = new String[Cantidad];
                                    String[] apellidos = new String[Cantidad];
                                    float[] tarifaH = new float[Cantidad];
                                    float[] ingresoEX = new float[Cantidad];
                                    float[] impuestoPagos = new float[Cantidad];
                                    float[] salarioSinImpuesto = new float[Cantidad];
                                    float[] salarioTotal = new float[Cantidad];
                                    float[] salario = new float[Cantidad];
                                    float[] salarioIncremento = new float[Cantidad];
                                    float[] incrementoTarifa = new float[Cantidad];
                                    int[] horasT = new int[Cantidad];
                                    int[] HoraEx = new int [Cantidad];

        do{                 
                            System.out.print("\n\nRegistro : #" + contadorR +"\n\nNombre: ");
                            nombres[contadorWhile] = entrada.next();

                            System.out.print("Apellido: ");
                            apellidos[contadorWhile] = entrada.next();

                            System.out.print("Tarifa por Hora de trabajo: ");
                            tarifaH[contadorWhile] = entrada.nextFloat();

                            System.out.print("Horas trabajadas: ");
                            horasT[contadorWhile] = entrada.nextInt();

                            //calcula el pago de los trabajdores
                            if(horasT[contadorWhile] > horasN){
                                        HoraEx[contadorWhile] = horasT[contadorWhile] - horasN;
                                        incrementoTarifa[contadorWhile] = tarifaH[contadorWhile] * 0.5f + tarifaH[contadorWhile];
                                        ingresoEX[contadorWhile] = incrementoTarifa[contadorWhile] * HoraEx[contadorWhile];
                                        salario[contadorWhile] = horasN * tarifaH[contadorWhile];
                                        salarioIncremento[contadorWhile] = salario[contadorWhile] + ingresoEX[contadorWhile];
                                        salarioSinImpuesto[contadorWhile] = salarioIncremento[contadorWhile];    
                                     }else{
                                        salarioSinImpuesto[contadorWhile] = horasT[contadorWhile] * tarifaH[contadorWhile];
                                        salario[contadorWhile] = horasT[contadorWhile] * tarifaH[contadorWhile];
                                     }

                                if(salarioSinImpuesto[contadorWhile] > impuestos){
                                         impuestoPagos[contadorWhile] = salarioSinImpuesto[contadorWhile] * 0.2f;
                                         salarioTotal[contadorWhile] = salarioSinImpuesto[contadorWhile] - impuestoPagos[contadorWhile];
                                     }else{
                                        salarioTotal[contadorWhile] = salarioSinImpuesto[contadorWhile];
                                     }
        contadorWhile = contadorWhile + 1;
        contadorR = contadorR + 1;
    }while(contadorWhile < Cantidad);


    //Menu
    int ejecucion = 0; 

    while(ejecucion == 0){
                int opcionP;

                System.out.print("\n\nMenu : "
                                + "\n1- Dato de un trabador especifico"
                                + "\n2- Nomina de todos los trabadores"
                                + "\n3- Cerrar programa "
                                + "\n\nOpcion: "); 
                opcionP = entrada.nextInt();

                    switch(opcionP){

                    case 1:

                        int num;
                         System.out.print("\nNumero del trabador : ");
                         num = entrada.nextInt();
                         num = num - 1;

                                if (num < Cantidad) {

                                    num = num + 1;
                                    System.out.print("Trabajador: ["+num+"]");
                                    num = num - 1;
                                    System.out.print("\nNombres y Apellidos : " + nombres[num] + " " + apellidos[num]);
                                    System.out.print("\nCantidad Horas Normales a trabajar : " + horasN); 
                                    System.out.print("\nCantidad de horas trabajadas: " + horasT[num]);
                                    System.out.print("\nTarifa HN : " + tarifaH[num]);
                                    System.out.print("\nCantidad Horas Extra : " + HoraEx[num]);
                                    System.out.print("\nIngreso HN : " + salario[num]);
                                    System.out.print("\nTarifa HE : " + incrementoTarifa[num]);
                                    System.out.print("\nIngreso HE : " + ingresoEX[num]);
                                    System.out.print("\nTotal Salario Bruto : " + salarioSinImpuesto[num]);
                                    System.out.print("\nDeducción por Impuesto : " + impuestoPagos[num]);
                                    System.out.print("\nTotal Salario Neto : " + salarioTotal[num]);
                                }else{System.out.print("Numero de trabajador no existente!! ");}break;

                    case 2:

                                    //Imprimir datos
                    System.out.print("Datos de salarios: \n\n");

                    int contado = 1;

                    for(int i = 0; i < Cantidad; i++){
                                System.out.print("Trabajador: ["+contado+"]");
                                System.out.print("\nNombres y Apellidos : " + nombres[i] + " " + apellidos[i]);
                                System.out.print("\nCantidad Horas Normales a trabajar : " + horasN); 
                                System.out.print("\nCantidad de horas trabajadas: " + horasT[i]);
                                System.out.print("\nTarifa HN : " + tarifaH[i]);
                                System.out.print("\nCantidad Horas Extra : " + HoraEx[i]);
                                System.out.print("\nIngreso HN : " + salario[i]);
                                System.out.print("\nTarifa HE : " + incrementoTarifa[i]);
                                System.out.print("\nIngreso HE : " + ingresoEX[i]);
                                System.out.print("\nTotal Salario Bruto : " + salarioSinImpuesto[i]);
                                System.out.print("\nDeducción por Impuesto : " + impuestoPagos[i]);
                                System.out.print("\nTotal Salario Neto : " + salarioTotal[i]);
                                contado = contado+1;   
                                System.out.print("\n\n"); 
                    }break;

                    case 3: ejecucion = ejecucion + 1;break;

                     default: System.out.print("Numero no valido\n\n");             

                }

        }

        System.out.print("\n\nFin del programa!!");
    }
}
