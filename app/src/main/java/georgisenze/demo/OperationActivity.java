package georgisenze.demo;

import android.view.View;

public class OperationActivity extends CalculatriceActivity{

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


}
