public class Horario {
    private byte segundo, minuto, hora;

    public void setSegundo(byte segundo) throws Exception{
        if (segundo < 0 || segundo > 59)
        throw new Exception("Segundo inválido");
        this.segundo=segundo;
    }

    public byte getSegundo(){
        return this.segundo;
    }

    public void setMinuto(byte minuto) throws Exception{
        if (minuto < 0 || minuto > 59)
        throw new Exception("Minuto inválido");
        this.minuto=minuto;
    }

    public byte getMinuto(){
        return this.minuto;
    }

    public void setHora(byte hora) throws Exception{
        if (hora < 0 || hora > 23)
        throw new Exception("Hora inválida");
        this.hora=hora;
    }

    public byte getHora(){
        return this.hora;
    }

    public Horario(byte hora, byte minuto, byte segundo) throws Exception {
        this.setHora(hora);
        this.setMinuto(minuto);
        this.setSegundo(segundo);
    }

    public void adiantarHora(int segundos) {
        int totalSegundos = hora * 3600 + minuto * 60 + segundo + segundos; // transforma tudo em segundos
        totalSegundos %= 86400; // 86400 segundos em um dia. Assim, se ultrapassar o dia, recomeça com segundos e assim adiante.

        if (totalSegundos < 0) {
            totalSegundos += 86400; // Corrige se o valor for negativo
        }

        this.hora = (byte) (totalSegundos / 3600);
        this.minuto = (byte) ((totalSegundos % 3600) / 60);
        this.segundo = (byte) (totalSegundos % 60);
    }

    public void atrasarHora(int segundos) {
        adiantarHora(-segundos);
    }

    public int diferencaHora(Horario outroHorario) {
        int thisTotalSegundos = this.hora * 3600 + this.minuto * 60 + this.segundo;
        int outroTotalSegundos = outroHorario.getHora() * 3600 + outroHorario.getMinuto() * 60 + outroHorario.getSegundo();

        int diferencaSegundos;

        if (thisTotalSegundos >= outroTotalSegundos) {
            diferencaSegundos = thisTotalSegundos - outroTotalSegundos;
        } else {
            diferencaSegundos = outroTotalSegundos - thisTotalSegundos;
        }

        return diferencaSegundos;
    }

    @Override
    public String toString(){
        return (this.hora<10?"0":"")+this.hora+
                ":"+
                (this.minuto<10?"0":"")+this.minuto+
                ":"+
                (this.segundo<10?"0":"")+this.segundo;

    }

    public boolean equals (Horario hor){
        if (this==hor) return true;
        if (hor == null) return false;
        if (this.hora!=hor.hora) return false;
        if (this.minuto!=hor.minuto) return false;
        if (this.segundo!=hor.segundo) return false;

        return true;
    }
}
