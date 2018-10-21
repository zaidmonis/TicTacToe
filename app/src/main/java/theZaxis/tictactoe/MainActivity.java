package theZaxis.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttons;
    Boolean chancePlayer1;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chancePlayer1 = true;
        buttons = new Button[3][3];
        for (int i=0 ; i<3 ; i++){
            switch (i){
                case 0:{
                    index=0;
                    break;
                }
                case 1:{
                    index=3;
                    break;
                }
                case 2:{
                    index=6;
                    break;
                }
            }
            for (int j=0 ; j<3 ; j++){
                String idNum = "button" +String.valueOf(index+j+1);
                int resId = getResources().getIdentifier(idNum, "id", getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setText("");
                buttons[i][j].setOnClickListener(this);
            }

        }
    }

    private void goOnClick(Button button) {
        Toast.makeText(this,button.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Button button;
        button = findViewById(v.getId());
        String txt;
        if (chancePlayer1){
            txt="X";
            chancePlayer1 = false;
        }
        else{
            txt="O";
            chancePlayer1 = true;
        }
        if (button.getText().equals("")){
            button.setText(txt);
            checkWhoWon();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void checkWhoWon() {
        //First horizontal
        if (buttons[0][0].getText().equals(buttons[0][1].getText()) && !buttons[0][0].getText().equals("")){
            if (buttons[0][0].getText().equals(buttons[0][2].getText())){
                Toast.makeText(this, buttons[0][0].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //second Horizontal
        if (buttons[1][0].getText().equals(buttons[1][1].getText()) && !buttons[1][0].getText().equals("")){
            if (buttons[1][0].getText().equals(buttons[1][2].getText())){
                Toast.makeText(this, buttons[1][0].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //Third horizontal
        if (buttons[2][0].getText().equals(buttons[2][1].getText()) && !buttons[2][0].getText().equals("")){
            if (buttons[2][0].getText().equals(buttons[2][2].getText())){
                Toast.makeText(this, buttons[2][0].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //First vertical
        if (buttons[0][0].getText().equals(buttons[1][0].getText()) && !buttons[0][0].getText().equals("")){
            if (buttons[0][0].getText().equals(buttons[2][0].getText())){
                Toast.makeText(this, buttons[0][0].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //Second Vertical
        if (buttons[0][1].getText().equals(buttons[1][1].getText()) && !buttons[0][1].getText().equals("")){
            if (buttons[0][1].getText().equals(buttons[2][1].getText())){
                Toast.makeText(this, buttons[0][1].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //Third vertical
        if (buttons[0][2].getText().equals(buttons[1][2].getText()) && !buttons[0][2].getText().equals("")){
            if (buttons[0][2].getText().equals(buttons[2][2].getText())){
                Toast.makeText(this, buttons[0][2].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //First Diagonal
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && !buttons[0][0].getText().equals("")){
            if (buttons[0][0].getText().equals(buttons[2][2].getText())){
                Toast.makeText(this, buttons[0][0].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
        //Second Diagonal
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && !buttons[0][2].getText().equals("")){
            if (buttons[0][2].getText().equals(buttons[2][0].getText())){
                Toast.makeText(this, buttons[0][2].getText().toString() +" Won", Toast.LENGTH_SHORT).show();
                resetButtons();
                return;
            }
        }
    }
    void resetButtons(){
        for (int i=0 ; i<3 ; i++){
            for (int j=0 ; j<3 ; j++){
                buttons[i][j].setText("");
            }
        }
    }
}
