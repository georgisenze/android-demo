package georgisenze.demo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import georgisenze.demo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumero = "";
    String op = "+";
    EditText edi;
    boolean isNewOp = true;
    boolean moinsNumber = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edi = findViewById(R.id.ediText);
    }



    public void numeroEvent(View view) {
        if (isNewOp)
            edi.setText("");
        isNewOp = false;
        String numero = edi.getText().toString();
        switch(view.getId()){
            case R.id.bu0:
                numero += "0";
                break;

            case R.id.bu1:
                numero += "1";
                break;

            case R.id.bu2:
                numero += "2";
                break;

            case R.id.bu3:
                numero += "3";
                break;

            case R.id.bu4:
                numero += "4";
                break;

            case R.id.bu5:
                numero += "5";
                break;

            case R.id.bu6:
                numero += "6";
                break;

            case R.id.bu7:
            numero += "7";
            break;

            case R.id.bu8:
                numero += "8";
                break;

            case R.id.bu9:
                numero += "9";
                break;

            case R.id.buVirgule:
                numero += ".";
                break;

            case R.id.buPlusMoin:
                for (int i=0; i<numero.length(); i++){
                    if (numero.charAt(i)=='-'){
                        moinsNumber = true;
                    }else
                        numero = "-"+numero;
                }
               ;
                break;
        }
        edi.setText(numero);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumero = edi.getText().toString();
        switch (view.getId()){
            case R.id.buDivision: op = "/"; break;
            case R.id.buMoins: op = "-"; break;
            case R.id.buPlus: op = "+"; break;
            case R.id.buMulti: op = "*"; break;

        }


    }

    public void equalEvent(View view) {
        String newNombre = edi.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumero)+ Double.parseDouble(newNombre);
                break;

            case "-":
                result = Double.parseDouble(oldNumero)- Double.parseDouble(newNombre);
                break;

            case "*":
                result = Double.parseDouble(oldNumero)* Double.parseDouble(newNombre);
                break;

            case "/":
                result = Double.parseDouble(oldNumero)/ Double.parseDouble(newNombre);
                break;

        }
        edi.setText(result+"");
    }

    public void acEvent(View view) {
        edi.setText("0");
        isNewOp = true;

    }

    public void pourcentEvent(View view) {
        double no = Double.parseDouble(edi.getText().toString())/100;
                edi.setText(no+"");
        isNewOp = true;
    }
}