package aplicacao.darocha.com.br.conversor_temperatura;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import aplicacao.darocha.com.br.conversor_temperatura.Model.Conversor;

public class MainActivity extends AppCompatActivity {

    private RadioButton c_1, f_1, k_1, c_2, f_2, k_2;
    private EditText temperatura;
    Conversor conversor = new Conversor();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, SobreActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void teste(View view){
        conversor.setTemperatura(temperatura.getText().toString());

        if(((c_1.isChecked() && f_2.isChecked()) || (c_1.isChecked() && k_2.isChecked())||
                (f_1.isChecked() && c_2.isChecked()) || (f_1.isChecked() && k_2.isChecked())
        || (k_1.isChecked() && c_2.isChecked()) || (k_1.isChecked() && f_2.isChecked())) && !conversor.getTemperatura().equals("")) {

             if(c_1.isChecked() && f_2.isChecked()){
                Toast.makeText(this, conversor.converterCelsius_F()+" ºF", Toast.LENGTH_SHORT).show();
            }else if(c_1.isChecked() && k_2.isChecked()){
                Toast.makeText(this, conversor.converterCelsius_K()+" K", Toast.LENGTH_SHORT).show();
            }else if(f_1.isChecked() && c_2.isChecked()){
                Toast.makeText(this, conversor.converterFahrenheit_C()+" ºC", Toast.LENGTH_SHORT).show();
            }else if(f_1.isChecked() && k_2.isChecked()){
                Toast.makeText(this, conversor.converterFahrenheit_K()+" K", Toast.LENGTH_SHORT).show();
            }else if(k_1.isChecked() && c_2.isChecked()){
                Toast.makeText(this, conversor.converterkelvin_C()+" ºC", Toast.LENGTH_SHORT).show();
            }else if(k_1.isChecked() && f_2.isChecked()){
                Toast.makeText(this, conversor.converterkelvin_F()+" ºF", Toast.LENGTH_SHORT).show();
            }
        }else if((c_1.isChecked() && c_2.isChecked()) || (f_1.isChecked() && f_2.isChecked()) || (k_1.isChecked() && k_2.isChecked())){
            Toast.makeText(this, this.getText(R.string.app_mensagem_temp_igual), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, this.getText(R.string.app_mensagem_temp_selecaoitem), Toast.LENGTH_SHORT).show();
        }
    }
}
