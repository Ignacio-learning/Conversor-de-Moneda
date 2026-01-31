void main() {
    Scanner lectura = new Scanner(System.in);
    ConsultaMoneda consulta = new ConsultaMoneda();
    int opcion = 0;

    String menu = """
            ***************************************************
             Sea bienvenido/a al Conversor de Moneda =)
              1) Dólar =>> Peso argentino
              2) Peso argentino =>> Dólar
              3) Dólar =>> Real brasileño
              4) Real brasileño =>> Dólar
              5) Dólar =>> Peso colombiano
              6) Peso colombiano =>> Dólar
              7) Salir
              Elija una opción válida:
            ***************************************************
       """;
    while (opcion != 7 ){
        System.out.println(menu);
        try {
            opcion = Integer.parseInt(lectura.nextLine());

            if (opcion == 7)
                break;
            System.out.println("Ingrese el valor que desea convertir: ");
            double valor = Double.parseDouble(lectura.nextLine());

            switch (opcion) {
                case 1 -> realizarConversion(consulta, "USD", "ARS", valor);
                case 2 -> realizarConversion(consulta, "ARS", "USD", valor);
                case 3 -> realizarConversion(consulta, "USD", "BRL", valor);
                case 4 -> realizarConversion(consulta, "BRL", "USD", valor);
                case 5 -> realizarConversion(consulta, "USD", "COP", valor);
                case 6 -> realizarConversion(consulta, "COP", "USD", valor);
                default -> System.out.println("Opcion no valida.");

            }
        } catch (NumberFormatException e){
            System.out.println("Error: Ingrese un numero valido");
        }
    }
    System.out.println("Finalizando la aplicacion. ¡Gracias!");
}

private static void realizarConversion(ConsultaMoneda consulta, String base, String objetivo, double valor){
    Moneda moneda = consulta.buscarMoneda(base);
    Map<String, Double> mapita  = moneda.conversion_rates();
    double tasa = mapita.get(objetivo);
    double resultado = valor * tasa;
    //System.out.println("El valor " + valor + " [" + base + "] corresponde al valor final de =>>> " + resultado + " [" + objetivo + "]");
    System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
            valor, base, resultado, objetivo);
}


