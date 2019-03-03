package aplicacao.darocha.com.br.conversor_temperatura.Model;

public class Conversor {
    private String temperatura;
    private Double conversao;

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setConversao(Double conversao) {
        this.conversao = conversao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public Double getConversao() {
        return conversao;
    }

    public String converterCelsius_F(){
        this.conversao = (tempereratura() * 9/5)+32;
        return String.format("%.2f", this.conversao);
    }

    public String converterCelsius_K(){
        conversao = (tempereratura() + 273.15);
        return String.format("%.2f", conversao);
    }

    public String converterFahrenheit_C(){
        conversao = (tempereratura()-32)*5/9;
        return String.format("%.2f", conversao);
    }

    public String converterFahrenheit_K(){
        conversao = (tempereratura()-32)*5/9 + 273.15;
        return String.format("%.2f", conversao);
    }

    public String converterkelvin_C(){
        conversao = tempereratura() - 273.15;
        return String.format("%.2f", conversao);
    }

    public String converterkelvin_F(){
        conversao =  (tempereratura() - 273.15) * 9/5 +32;
        return String.format("%.2f", conversao);
    }

    public Double tempereratura(){
        return Double.parseDouble(this.temperatura.toString());
    }
}
