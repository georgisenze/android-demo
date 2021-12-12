package georgisenze.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

public class CalculatriceActivity extends AppCompatActivity {

    String oldNumero = "";
    String op = "+";
    EditText edi;
    boolean isNewOp = true;
    boolean moinsNumber = false;
    boolean virg = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

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
                for (int i=0; i<numero.length(); i++){
                    if (numero.charAt(i)=='.'){
                        virg = true;
                    }
                    if (!virg){
                        numero += ".";
                    }
                }

                break;

            case R.id.buPlusMoin:
                for (int i=0; i<numero.length(); i++){
                    if (numero.charAt(i)=='-'){
                        moinsNumber = true;
                    }
                    if(!moinsNumber){
                        numero = "-" + numero;
                    }
                }
                break;

            default:
                break;
        }
        edi.setText(numero);
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

    public void operatorEvent(View view) {
        OperationActivity ope = new OperationActivity();
        ope.operatorEvent(view);
    }

    public void equalEvent(View view) {
        OperationActivity ope = new OperationActivity();
        ope.equalEvent(view);
    }
}