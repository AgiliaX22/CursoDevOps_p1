import java.util.*;
import java.time.*;//LocalDate;

public class Main
{
    static String [][] movimiento = new String[10][4];
    static int a = 0, b = 0, i = 0;
    static boolean salir = false;
    
    static boolean menu_salir(){
        boolean salida = false;
        Scanner leer = new Scanner(System.in);
        String op;
        do{
            System.out.println();
            System.out.println("1. Menú principal\n2. Salir\n");
            System.out.print("Seleccione una opción ");
            op = leer.nextLine();
            System.out.println();
            if (op.equals("1") || op.equals("2")){
                switch(op){
                    case "1":
                       salida = false;
                       break;
                    case "2":
                        salida = true;
                        break;
                }
            }
            else{
                System.out.println("Opción incorrecta, intente nuevamente\n");
            } 
        } while((!(op.equals("1"))) && (!(op.equals("2"))));
        return salida;
    }
    
    static void movimientos(int a,float retiro,float saldo_anterior){

        movimiento[a][0] = "FECHA: " + LocalDate.now(ZoneId.of("America/Mexico_City"));
        movimiento[a][1] = "FECHA: " + LocalTime.now(ZoneId.of("America/Mexico_City"));
        movimiento[a][2] = "RETIRO: $" + String.valueOf(retiro);
        movimiento[a][3] = "SALDO ANTERIOR: $" + String.valueOf(saldo_anterior);
    }
    
    
    static boolean menu(){
        String opcion, aux;
        float saldo = 1000, retiro, saldo_anterior;
        Scanner leer = new Scanner(System.in);

        while (!salir){
            System.out.println("\t\tMENU");
            System.out.println("1.Consultar saldo\n2.Retirar saldo\n3.Histórico de movimientos\n");
            System.out.print("Seleccione una opción   ");
            opcion = leer.nextLine();
            switch(opcion){
                case "1":
                    System.out.println("Saldo disponible: " + saldo +"\n" );
                    salir = menu_salir();
                    break;
                case "2":
                    do{
                        try{
                            System.out.print("Digite la cantidad a retirar  ");
                            retiro = leer.nextFloat();
                            System.out.println();
                            if ((retiro > saldo) || (saldo == 0)){
                                System.out.println("Error, fondos insuficientes");
                                aux = "si";
                            }
                            else{
                                saldo_anterior = saldo;
                                saldo = saldo - retiro;
                                movimientos(a,retiro, saldo_anterior);
                                a +=1;
                                System.out.println("Operación exitosa\nSaldo disponible $"+ saldo);
                                aux = "no";
                            }
                        }
                        catch(InputMismatchException ex){
                            System.out.println("Error, solo se aceptan valores númericos\nIntente nuevamente\n");
                            leer.next();
                            aux = "si";
                        }
                    } while (aux.equals("si"));
                    salir = menu_salir();
                    break;
                case "3":
                    for (int x=0; x < a; x++) {
                        for (int y=0; y < movimiento[x].length; y++) {
                            System.out.println(movimiento[x][y]);
                        }
                        System.out.println();
                    }
                    salir = menu_salir();
                    break;
                default:
                    System.out.println("Error, opción incorrecta\n");
            }
        }
        return salir;
    }
    
	public static void main(String[] args) {
        String contraseña;
        
        while (i < 3 && !salir) {
            Scanner leer = new Scanner(System.in);
            System.out.print("Ingrese el PIN   ");
            contraseña = leer.nextLine();
            if (contraseña.equals("1235")){
                System.out.println("\nBienvenido AGILIA ELIA ORTEGA RODRIGUEZ");
                salir = menu();
            } 
            else{
                System.out.println("Error PIN incorrecto\n");
                i += 1;
            }
        }
	}
}



