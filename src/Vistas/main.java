
package Vistas;

import Modelo.Producto;
import Persistencia.ProductosData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        VentPrincipal ventana = new VentPrincipal();
        ventana.setVisible(true);
        
        
        System.out.println("/////   Trabajo Práctico Restaurante, Grupo 2, 2024, Comision 2 /////");
        System.out.println("////\n///// por: Walter Alexander Vertacnik,");
        System.out.println("////       Soto Vela Luciano Ezequiel, ");
        System.out.println("////       Ferro Julieta, ");
        System.out.println("////       Pagnone Patricia, ");
        System.out.println("////       Muñoz Maycol\n//");
        
        Set<String> accionesValidas = new HashSet<>();
        ProductosData pdata = new ProductosData();
        accionesValidas.add("1");
        accionesValidas.add("2");
        accionesValidas.add("3");
        accionesValidas.add("4");
        accionesValidas.add("5");
        accionesValidas.add("6");
        accionesValidas.add("7");
        accionesValidas.add("listar");
        accionesValidas.add("guardar");
        accionesValidas.add("inhabilitar");
        accionesValidas.add("actualizar");
        accionesValidas.add("buscar");
        accionesValidas.add("filtrar");
        accionesValidas.add("salir");
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidas con alcohol");
        categorias.add("bebidas sin alcohol");
        categorias.add("bebidas gaseosas");
        
        String accion = "";
        Scanner leerInt = new Scanner(System.in);
        Scanner leerString = new Scanner(System.in);
        boolean seguir = true;
        
        do {
            try {
            Thread.sleep(20); // 50 milisegundos para que poder cargar los prints a continuacion correctamente y no se sobrepongan
            } catch (InterruptedException e) {}
            System.out.println("/// Bienvenido a la consola para gestionar la base de datos de los productos del Restaurante Entre Amigos ///");
            System.out.println("//                 (1/listar) Lista los productos de la base de datos");
            System.out.println("//                 (2/buscar) Busca un producto en la base de datos por codigo del producto");
            System.out.println("//                 (3/guardar) Inserta un nuevo producto a la base de datos");
            System.out.println("//                 (4/inhabilitar) Cambia el Estado de un producto de la base de datos para deshabilitarlo");
            System.out.println("//                 (5/actualizar) Actualiza los datos de un producto por codigo del producto");
            System.out.println("//                 (6/filtrar) filtra los productos que quieras ver por categoria");
            System.out.println("//                 (7/salir) filtra los productos que quieras ver por categoria\n//");

            accion = "";

            System.out.print("//// Ingrese a continuación el número o la palabra para realizar alguna acción\n//// : ");
            do {
                accion = leerString.nextLine();
                if (!accionesValidas.contains(accion.toLowerCase())) {
                    System.err.println("//// Accion invalida intentelo de nuevo");
                    System.out.print("//// : ");
                }
            } while (!accionesValidas.contains(accion.toLowerCase()));
            
            switch (accion.toLowerCase()) {
                case ("1") : case ("listar") : {
                    try {
                        ArrayList<Producto> lista = pdata.listar();
                        System.out.println("\n///// Lista de productos /////");
                        for (Producto p : lista) {
                            System.out.println(" - "+p);
                        }
                        System.out.println("");
                    } catch (SQLException ex) {
                        System.err.println("Error de SQL");
                    }
                    break;
                }
                case ("2") : case ("buscar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = null;
                    boolean valido = true;
                    System.out.print("//// Ingrese la código del produto que quiera buscar\n//// : ");
                    do {
                        valido = true;
                        try {
                            p = pdata.buscar(leerInt.nextInt());
                        } catch (SQLException ex) {
                            System.err.println("Error de SQL");
                        } catch (Exception ex) {
                            System.err.println("El valor ingresado es invalido, tiene que ser un entero");
                            valido = false;
                        }
                        if (!valido) {
                            leerInt.next();
                            System.out.print("//// Código invalido, Intentelo nuevamente\n//// : ");
                        }
                    } while (!valido);
                    if (p==null) {
                        System.out.println("\nProducto no encontrado\n");
                    }else{
                        System.out.println("\n - "+p+"\n");
                    }
                    break;
                }
                case ("3") : case ("guardar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = new Producto();
                    p.setCodigo(0);
                    boolean valido = true;
                    System.out.print("//// Ingrese el nombre del nuevo produto\n//// : ");
                    do {
                        valido = true;
                        p.setNombre(leerString.nextLine());
                        if (p.getNombre().trim().isEmpty()|p.getNombre().isEmpty()) {
                            System.err.print("//// El nombre del producto está vacio, intentelo nuevamente\n//// : ");
                            valido=false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese el precio del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        try {
                            p.setPrecio(leerInt.nextDouble());
                        } catch (InputMismatchException e) {
                            System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                            leerInt.nextLine();
                            valido = false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el estado del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        String estado = leerString.nextLine();
                        switch (estado.toLowerCase()) {
                            case ("1") : case ("habilitado") : {
                                p.setEstado(true);break;
                            }
                            case ("2") : case ("inhabilitado") : {
                                p.setEstado(false);break;
                            }
                            default : {
                                System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                valido = false;
                                break;
                            }
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese un número entero para el stock del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        try {
                            p.setStock(leerInt.nextInt());
                        } catch (InputMismatchException e) {
                            System.err.print("//// valor invalido, tiene que ser un entero, intentelo nuevamente\n//// : ");
                            leerInt.nextLine();
                            valido = false;
                        }
                    } while (!valido);
                    System.out.print("//// Ingrese la categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del nuevo producto\n//// : ");
                    do {
                        valido = true;
                        String opcion = leerString.nextLine();
                        switch (opcion.toLowerCase()) {
                            case ("1") : case ("pizzas") : {
                                p.setCategoria("pizzas");break;
                            }
                            case ("2") : case ("lomos") : {
                                p.setCategoria("lomos");break;
                            }
                            case ("3") : case ("hamburguesas") : {
                                p.setCategoria("hamburguesas");break;
                            }
                            case ("4") : case ("tacos") : {
                                p.setCategoria("tacos");break;
                            }
                            case ("5") : case ("bebidas con alcohol") : {
                                p.setCategoria("bebidas con alcohol");break;
                            }
                            case ("6") : case ("bebidas sin alcohol") : {
                                p.setCategoria("bebidas sin alcohol");break;
                            }
                            case ("7") : case ("bebidas gaseosas") : {
                                p.setCategoria("bebidas gaseosas");break;
                            }
                            default : {
                                System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                                valido = false;
                                break;
                            }
                        }
                    } while (!valido);
                    System.out.print("\n//// ");
                    try {
                        pdata.guardarProducto(p);
                        p.setCodigo(pdata.listar().size());
                    } catch (SQLException ex) {
                        System.err.println("Error SQL al mostrar el producto guardado");
                    }
                    System.out.println(" - "+p+"\n");
                    break;
                }
                case ("4") : case ("inhabilitar") : { //////////////////  UN CASE  ///////////////////
                    boolean valido = true;
                    System.out.print("//// Ingrese el código del producto que desea inhabilitar\n//// : ");
                    do {
                        valido = true;
                        try {
                            pdata.CambiarEstado(false,leerInt.nextInt());
                        } catch (SQLException ex) {
                            System.err.println("Error de SQL");
                        } catch (Exception ex) {
                            System.err.println("El valor ingresado es invalido, tiene que ser un entero");
                            valido = false;
                        }
                        if (!valido) {
                            leerInt.next();
                            System.out.print("//// Código invalido, Intentelo nuevamente\n//// : ");
                        }
                    } while (!valido);
                    break;
                }
                case ("5") : case ("actualizar") : { //////////////////  UN CASE  ///////////////////
                    Producto p = new Producto(null, 0, false, 0, null);
                    boolean valido = true;
                    String opcions = null;
                    System.out.print("//// Ingrese el código del producto que desea actualizar, ingrese 0 para cancelar\n//// : ");
                    do {
                        valido = true;
                        opcions = String.valueOf(leerInt.nextInt());
                        if ("0".equals(opcions)) {
                            System.out.println("///// Operacion cancelada /////\n");
                            break;
                        }else{
                            try {
                                p.setCodigo(Integer.parseInt(opcions));
                            } catch (NumberFormatException ex) {
                                System.out.print("//// Código invalido, Intentelo nuevamente o ingrese 0 para cancelar\n//// : ");
                                leerInt.next();
                                valido = false;
                            }
                        }
                    } while (!valido);
                try {
                    if (pdata.buscar(p.getCodigo())!=null) {
                        System.out.print("//// Ingrese que atributos del producto desea actualizar: (nombre, precio, stock, categoria, estado) puede ponerlo asi para todos o solo algunos\n//// : ");
                        String filtros = leerString.nextLine().toLowerCase();
                        if (filtros.contains("nombre")) {
                            System.out.print("//// Ingrese el nuevo nombre del produto\n//// : ");
                            do {
                                valido = true;
                                p.setNombre(leerString.nextLine());
                                if (p.getNombre().trim().isEmpty()|p.getNombre().isEmpty()) {
                                    System.err.print("//// El nombre del producto está vacio, intentelo nuevamente\n//// : ");
                                    valido=false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("precio")) {
                            System.out.print("//// Ingrese el precio del nuevo producto\n//// : ");
                            do {
                                valido = true;
                                try {
                                    p.setPrecio(leerInt.nextDouble());
                                } catch (InputMismatchException e) {
                                    System.err.print("//// valor invalido, tiene que ser un numero, intentelo nuevamente\n//// : ");
                                    leerInt.nextLine();
                                    valido = false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("estado")) {
                            System.out.print("//// Ingrese (1|habilitado o 2|inhabilitado) para el nuevo estado del producto\n//// : ");
                            do {
                                valido = true;
                                String estado = leerString.nextLine();
                                switch (estado.toLowerCase()) {
                                    case ("1") : case ("habilitado") : {
                                        p.setEstado(true);break;
                                    }
                                    case ("2") : case ("inhabilitado") : {
                                        p.setEstado(false);break;
                                    }
                                    default : {
                                        System.err.print("//// Invalido debe ingresar una de estas opciones (1|habilitado o 2|inhabilitado), intentelo nuevamente\n//// : ");
                                        valido = false;
                                        break;
                                    }
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("stock")) {
                            System.out.print("//// Ingrese un número entero para el nuevo stock del producto\n//// : ");
                            do {
                                valido = true;
                                try {
                                    p.setStock(leerInt.nextInt());
                                } catch (InputMismatchException e) {
                                    System.err.print("//// valor invalido, tiene que ser un entero, intentelo nuevamente\n//// : ");
                                    leerInt.nextLine();
                                    valido = false;
                                }
                            } while (!valido);
                        }
                        if (filtros.contains("categoria")) {
                            System.out.print("//// Ingrese la nueva categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del producto\n//// : ");
                            do {
                                valido = true;
                                String opcion = leerString.nextLine();
                                switch (opcion.toLowerCase()) {
                                    case ("1") : case ("pizzas") : {
                                        p.setCategoria("pizzas");break;
                                    }
                                    case ("2") : case ("lomos") : {
                                        p.setCategoria("lomos");break;
                                    }
                                    case ("3") : case ("hamburguesas") : {
                                        p.setCategoria("hamburguesas");break;
                                    }
                                    case ("4") : case ("tacos") : {
                                        p.setCategoria("tacos");break;
                                    }
                                    case ("5") : case ("bebidas con alcohol") : {
                                        p.setCategoria("bebidas con alcohol");break;
                                    }
                                    case ("6") : case ("bebidas sin alcohol") : {
                                        p.setCategoria("bebidas sin alcohol");break;
                                    }
                                    case ("7") : case ("bebidas gaseosas") : {
                                        p.setCategoria("bebidas gaseosas");break;
                                    }
                                    default : {
                                        System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                                        valido = false;
                                        break;
                                    }
                                }
                            } while (!valido);
                        }
                        pdata.actualizar(p,filtros);
                        System.out.println(" - "+pdata.buscar(p.getCodigo())+"\n");
                        break;
                    }else {
                        if (!"0".equals(opcions)) {
                            System.err.println("Producto no encontrado");
                        }
                        break;
                    }
                } catch (SQLException ex) {
                    System.err.println("Error SQL: "+ex);
                }}
                case ("6") : case ("filtrar") : { //////////////////  UN CASE  ///////////////////
                    boolean valido = true;
                    String filtro = null;
                    System.out.print("//// Ingrese la nueva categoria (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas) del producto\n//// : ");
                    do {
                        valido = true;
                        filtro = leerString.nextLine();
                        if (!categorias.contains(filtro)) {
                            System.err.print("//// Invalido debe ingresar una de estas opciones (1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas), intentelo nuevamente\n//// : ");
                            valido = false;
                        }else {
                            switch (filtro) {
                                case ("1") : {filtro="pizzas";break;}
                                case ("2") : {filtro="lomos";break;}
                                case ("3") : {filtro="hamburguesas";break;}
                                case ("4") : {filtro="tacos";break;}
                                case ("5") : {filtro="bebidas con alcohol";break;}
                                case ("6") : {filtro="bebidas sin alcohol";break;}
                                case ("7") : {filtro="bebidas gaseosas";break;}
                            }
                        }
                    } while (!valido);
                    try {
                        ArrayList<Producto> lista = pdata.filtrarCategoria(filtro);
                        System.out.println("\n///// Lista de productos de la categoria "+filtro+" /////");
                        for (Producto p : lista) {
                            System.out.println(" - "+p);
                        }
                        System.out.println("");
                    } catch (SQLException ex) {
                        System.err.println("Error de SQL: "+ex);
                    }
                    break;
                }
                case ("7") : case ("salir") : {
                    seguir = false;break;
                }
            }
            
        } while (seguir);
        
        System.out.println("\nFin de la ejecucion\n");
        
    }
    
}
