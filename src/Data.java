public class Data {
    private byte dia, mes;
    private short ano;
    
    public void setDia(byte dia) throws Exception {
        if (dia < 1 || dia > 31)
            throw new Exception("Dia inválido");

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)
            throw new Exception("Dia inválido");

        if (mes == 2) {
            if (isAnoBissexto()) {
                if (dia > 29)
                    throw new Exception("Dia inválido para fevereiro em ano bissexto");
            } else {
                if (dia > 28)
                    throw new Exception("Dia inválido para fevereiro em ano não bissexto");
            }
        }

        this.dia = dia;
    }
    
    public void incrementaDia(){
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)&& dia == 30){
            dia = 1;
            mes++;
        }
        else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10)&& dia == 31){
            dia = 1;
            mes++;
        }
        else if (mes == 12 && dia == 31){
            dia = 1;
            mes = 1;
            ano++;
        }
        else if (mes == 2){
            if (isAnoBissexto()){
                if (dia == 29){
                    dia = 1;
                    mes++;
                } else{
                    dia++;
                }
            } else{
                if (dia == 28){
                    dia = 1;
                    mes++;
                } else{
                    dia++;
                }
            }
        }
        else{
            dia++;
        }
    }

    public void incrementarDias(int dias){
        for (int i = 0; i<dias; i++){
            incrementaDia();
        }
    }

    public void decrementarDias(int dias){
        for (int i = 0; i<dias; i++){
            decrementaDia();
        }
    }

    public void decrementaDia(){
        if ((mes == 5 || mes == 7 || mes == 10 || mes == 12)&& dia == 1){
            dia = 30;
            mes--;
        }
        else if ((mes == 2 || mes == 4 || mes == 6 || mes == 8 || mes == 9 || mes == 11)&& dia == 1){
            dia = 31;
            mes--;
        }
        else if (mes == 1 && dia == 1){
            dia = 31;
            mes = 12;
            ano--;
        }
        else if (mes == 3){
            if (isAnoBissexto()){
                if (dia == 1){
                    dia = 29;
                    mes--;
                } else{
                    dia--;
                }
            } else{
                if (dia == 1){
                    dia = 28;
                    mes--;
                } else{
                    dia--;
                }
            }
        }
        else{
            dia--;
        }
    }

    private boolean isAnoBissexto() {
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public byte getDia ()
    {
        return this.dia;
    }

    public void setMes (byte mes) throws Exception
    {
        if (mes<1 || mes>12)
            throw new Exception ("Mes invalido");

        this.mes=mes;
    }

    public byte getMes()
    {
        return this.mes;
    }

    public void setAno (short ano) throws Exception
    {
        if (ano<=0) throw new Exception ("Ano invalido");

        this.ano=ano;
    }

    public short getAno()
    {
        return this.ano;
    }
    

    public Data (byte dia, byte mes, short ano) throws Exception{
            this.setDia(dia);
            this.setMes(mes);
            this.setAno(ano);
    }

    @Override
    public String toString(){
        return (this.dia<10?"0":"")+this.dia+
                "/"+
                (this.mes<10?"0":"")+this.mes+
                "/"+
                this.ano;

    }

    @Override
    public boolean equals (Object obj){
        if (this==obj) return true;
        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;
        Data dat = (Data)obj;
        if (this.dia!=dat.dia) return false;
        if (this.mes!=dat.mes) return false;
        if (this.ano!=dat.ano) return false;

        return true;
    }

}
