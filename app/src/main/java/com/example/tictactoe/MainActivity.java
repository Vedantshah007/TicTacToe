package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;

    int active =0;
    int cnt=0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winposi = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void tap(View view){
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(cnt==9){
            gameactive=false;
        }
        if(gamestate[tappedimage]==2){
            cnt++;
            gamestate[tappedimage]=active;
            img.setTranslationY(-1000f);
            if(active==0){
                img.setImageResource(R.drawable.x);
                active=1;
                if(cnt==9){
                    for(int[] win : winposi){
                        if(gamestate[win[0]]==gamestate[win[1]] && gamestate[win[1]]==gamestate[win[2]] && gamestate[win[0]]!=2){
                            cnt=0;
                            String winner;
                            gameactive=false;
                            if(gamestate[win[0]]==0){
                                winner="X has won";
                            }
                            else{
                                winner="0 has won";
                            }
                            TextView stat = findViewById(R.id.stat);
                            stat.setText(winner);
                        }
                    }
                    if(cnt==9){
                        TextView stat = findViewById(R.id.stat);
                        stat.setText("Match Tied");
                    }
                }
                else{
                    TextView stat = findViewById(R.id.stat);
                    stat.setText("O's Turn - Tap to play");
                }
            }
            else{
                img.setImageResource(R.drawable.o);
                active=0;
                TextView stat = findViewById(R.id.stat);
                stat.setText("X's Turn - Tap to play");
            }
//            img.animate().translationYBy(1000f).setDuration(300);
            img.animate().translationYBy(1000f);
        }
        if(!gameactive){
            gameReset(view);
        }
        for(int[] win : winposi){
            if(gamestate[win[0]]==gamestate[win[1]] && gamestate[win[1]]==gamestate[win[2]] && gamestate[win[0]]!=2){
                cnt=0;
                String winner;
                gameactive=false;
                if(gamestate[win[0]]==0){
                    winner="X has won";
                }
                else{
                    winner="0 has won";
                }
                TextView stat = findViewById(R.id.stat);
                stat.setText(winner);
            }
        }
    }

    public void gameReset(View view){
        cnt=0;
        gameactive=true;
        active=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView stat = findViewById(R.id.stat);
        stat.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}