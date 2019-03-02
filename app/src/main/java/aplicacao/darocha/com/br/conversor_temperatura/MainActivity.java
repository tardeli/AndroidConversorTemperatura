package aplicacao.darocha.com.br.conversor_temperatura;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioButton c_1, f_1, k_1, c_2, f_2, k_2;
    private EditText temperatura;
    private Double conversao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c_1 = (RadioButton) findViewById(R.id.radioButtonC_1);
        f_1 = (RadioButton) findViewById(R.id.radioButtonF_1);
        k_1 = (RadioButton) findViewById(R.id.radioButtonK_1);
        c_2 = (RadioButton) findViewById(R.id.radioButtonC_2);
        f_2 = (RadioButton) findViewById(R.id.radioButtonF_2);
        k_2 = (RadioButton) findViewById(R.id.radioButtonk_2);
        temperatura = (EditText) findViewById(R.id.editText_Temp);

    }


    protected void teste(View view){

        if((c_1.isChecked() && f_2.isChecked()) || (c_1.isChecked() && k_2.isChecked())||
                (f_1.isChecked() && c_2.isChecked()) || (f_1.isChecked() && k_2.isChecked())
        || (k_1.isChecked() && c_2.isChecked()) || (k_1.isChecked() && f_2.isChecked()) && !this.temperatura.equals("")) {

             if(c_1.isChecked() && f_2.isChecked()){
                Toast.makeText(this, converterCelsius_F()+" ºF", Toast.LENGTH_SHORT).show();
            }else if(c_1.isChecked() && k_2.isChecked()){
                Toast.makeText(this, converterCelsius_K()+" K", Toast.LENGTH_SHORT).show();
            }else if(f_1.isChecked() && c_2.isChecked()){
                Toast.makeText(this, converterFahrenheit_C()+" ºC", Toast.LENGTH_SHORT).show();
            }else if(f_1.isChecked() && k_2.isChecked()){
                Toast.makeText(this, converterFahrenheit_K()+" K", Toast.LENGTH_SHORT).show();
            }else if(k_1.isChecked() && c_2.isChecked()){
                Toast.makeText(this, converterkelvin_C()+" ºC", Toast.LENGTH_SHORT).show();
            }else if(k_1.isChecked() && f_2.isChecked()){
                Toast.makeText(this, converterkelvin_F()+" ºF", Toast.LENGTH_SHORT).show();
            }
        }else if((c_1.isChecked() && c_2.isChecked()) || (f_1.isChecked() && f_2.isChecked()) || (k_1.isChecked() && k_2.isChecked())){
            Toast.makeText(this,"Selecione uma temperatura diferente para realizar a conversão!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "È preciso digitar um valor e selecionar a tempepatura que deseja a conversão!", Toast.LENGTH_SHORT).show();
        }

    }

    public String converterCelsius_F(){
        conversao = (tempereratura() * 9/5)+32;
        return String.format("%.2f", conversao);
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
        return Double.parseDouble(this.temperatura.getText().toString());
    }
}
