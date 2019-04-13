package csie2c.tku.edittext;

import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.cat);
    }

    int size = 30; //sp

    public void responds(View V){
        EditText ed1,ed2,ed3;
        TextView txv;

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.textview);

        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI1 = calculateBMI(height,weight);
        String BMI2 = String.valueOf(BMI1);

        txv.setTextSize(size);
        txv.setTextColor(getResources().getColor(R.color.red));
        txv.setText(getResources().getString(R.string.hello)+
                    "  "+
                    ed1.getText().toString()+
                    "\n"+
                    getResources().getString(R.string.yourBMI)+"\n"+
                    BMI2);
        Toast.makeText(this,standardBMI(BMI1),Toast.LENGTH_LONG).show();
    }


    private float calculateBMI(float height,float weight){
        float BMI = (float)(weight/Math.pow(height/100,2));
        return BMI;
    }

    private String standardBMI(double BMI){
        String alert = "";

        if(BMI>25){
            alert = String.valueOf("You are too heavy");
            getWindow().setBackgroundDrawableResource(R.drawable.fat_cat);
        }
        else if(BMI < 18.5){
            alert = String.valueOf("You are too slim");
            getWindow().setBackgroundDrawableResource(R.drawable.sad_cat);
        }
        else{
            alert = String.valueOf("Your body is good");
        }

        return alert;
    }
}