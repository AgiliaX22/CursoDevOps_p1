'''
Hacer un programa que simule un cajero automático con un saldo inicial de $1000
y tendrá el siguiente menú de opciones:
    1. Consultar saldo
    2. Retirar saldo
    3. Histórico de movimientos
'''
# Hice un comentario para realizar un cambio para el examen XD XD

import time

saldo = 1000
i = 0
salir = False
movimientos = {}
historico_movimientos =[]


def Salir():
    while True:
        print("1. Menú principal\n2. Salir")
        dato = input("")
        if dato == "1":
            salir = False
            break
        elif dato =="2":
            salir = True
            break
        else:
            print("Opción incorrecta, intente nuevamente\n")
    return salir

def movimientos(retiro, saldo_anterior):
    movimientos= {"FECHA  ": time.strftime("%d/%m/%y"),"HORA  ": time.strftime("%H:%M:%S") ,"CANTIDAD ENTREGADA:   $": retiro, "SALDO ANTERIOR:   $": saldo_anterior }
    historico_movimientos.append(movimientos)

while i < 3:
    contra = (input("Ingresar PIN: "))
    print()
    if contra == "1235":
        print("Bienvenido AGILIA ELIA ORTEGA RODRIGUEZ")
        while  not salir:
            print("\t \t MENU\n1. Consultar saldo\n2. Retirar saldo\n3. Histórico de movimientos\n")
            try:
                opcion = int(input("Ingrese una opción: "))
                print()
                if opcion == 1:
                    print(f"\nSaldo disponible  ${saldo:.2f}\n")
                    salir = Salir()
                elif opcion == 2:
                    while True:
                        try:
                            retiro = float(input("\nDigite la cantidad a retirar: "))
                            if retiro > saldo or saldo == 0:
                                print("\nError fondos insuficientes\n")
                                salir = Salir()
                            else:
                                saldo_anterior = saldo
                                saldo = saldo - retiro
                                movimientos(retiro, saldo_anterior)
                                print(f"\nOperación exitosa\n Saldo disponible  ${saldo:.2f}\n")
                                salir = Salir()
                        except ValueError:
                            print("Entrada invalida, ingrese correctamente los valores númericos\n")
                        else:
                            break
                elif opcion == 3:
                    for a in historico_movimientos:
                        for b, c in a.items():
                            print(b, c)
                        print()
                    salir = Salir()
                else:
                    print("Error opción incorrecta\n")
            except ValueError:
                print("Error, solo se permiten números\n")
        else:
            break
    else:
        print("PIN incorrecto\n")
        i += 1


