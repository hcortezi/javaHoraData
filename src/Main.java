public class Main {
    public static void main(String[] args) 
    {
        try
        {
            Data d = new Data((byte)28, (byte)2, (short)2023);

            System.out.println("Data formatada com override do toString(): "+d.toString());
            d.setDia((byte)28);
            d.setMes((byte)2);
            d.setAno((short)1999);

            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno()); // Não é ano bissexto. 28 dias
            d.incrementaDia(); // Teste método de incrementar 1 dia
            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno());
            d.decrementaDia(); // Teste método decrementar 1 dia
            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno());
            d.incrementarDias(366); // Teste do método de incrementar N dias. Ano bissexto. 29 dias
            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno());
            d.incrementaDia();
            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno());
            d.decrementarDias(600); // Teste do método de decrementar N dias
            System.out.printf("Hoje é %d/%d/%d\n", d.getDia(), d.getMes(), d.getAno());
            System.out.println("Data formata com override do toString(): "+d);

            Horario h1 = new Horario((byte)10, (byte)30, (byte)0);
            Horario h2 = new Horario((byte)14,(byte)45, (byte)30);
            
            System.out.printf("Horário 1: %02d:%02d:%02d\n", h1.getHora(), h1.getMinuto(), h1.getSegundo());
            System.out.printf("Horário 2: %02d:%02d:%02d\n", h2.getHora(), h2.getMinuto(), h2.getSegundo());

            // Teste método adiantarHora
            h1.adiantarHora(3700); // Adiantando 3700 segundos (1h 1m 40s)
            System.out.printf("Horário 1 adiantado: %02d:%02d:%02d\n", h1.getHora(), h1.getMinuto(), h1.getSegundo());

            // Teste método atrasarHora
            h2.atrasarHora(7200); // Atrasando 7200 segundos (2h)
            System.out.printf("Horário 2 atrasado: %02d:%02d:%02d\n", h2.getHora(), h2.getMinuto(), h2.getSegundo());

            // Teste diferença entre os dois horários
            System.out.printf("Diferença entre os dois horários é de %d segundos\n", h1.diferencaHora(h2));

        }
        catch (Exception erro)
        {
            System.err.println(erro.getMessage());
        }
    }
}
