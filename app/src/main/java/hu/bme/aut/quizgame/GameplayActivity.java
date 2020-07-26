package hu.bme.aut.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.quizgame.Questions.Question;
import hu.bme.aut.quizgame.Scores.ScoreItem;
import hu.bme.aut.quizgame.Scores.ScoreListDatabase;
import hu.bme.aut.quizgame.adapter.ScoreAdapter;
import hu.bme.aut.quizgame.fragments.GameOverFragment;
import hu.bme.aut.quizgame.fragments.NewScoreItemDialogFragment;

public class GameplayActivity extends AppCompatActivity implements NewScoreItemDialogFragment.NewScoreItemDialogListener{


    private List<Question> questions = new ArrayList<>();
    public int level=1;
    private int currentQuestion;
    private ScoreAdapter adapter;

    private ScoreListDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = Room.databaseBuilder(
                getApplicationContext(),
                ScoreListDatabase.class,
                "score-list"
        ).build();

        setContentView(R.layout.activity_gameplay);
        final Button btnA = findViewById(R.id.btnA);
        final Button btnB = findViewById(R.id.btnB);
        final Button btnC = findViewById(R.id.btnC);
        final Button btnD = findViewById(R.id.btnD);


        init();
        nextQuestion(level);


        final Button btnAudience = findViewById(R.id.btnAudience);
        btnAudience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                switch(questions.get(currentQuestion).getSolution()) {
                    case ("A"): btnA.setTextColor(Color.CYAN);break;
                    case ("B"): btnB.setTextColor(Color.CYAN);break;
                    case ("C"): btnC.setTextColor(Color.CYAN);break;
                    case ("D"): btnD.setTextColor(Color.CYAN);break;
                }
                btnAudience.setEnabled(false);
                btnAudience.setTextColor(Color.RED);
            }
        });
        final Button btnFiftyfifty = findViewById(R.id.btnFiftyfifty);
        btnFiftyfifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                int found=0;
                int first=12;
                while(found<2) {
                    int i=(int) (Math.random() * 3 + 0);
                        switch(i) {
                            case(0):if (!questions.get(currentQuestion).getSolution().equals("A") && first!=0){
                                btnA.setTextColor(Color.DKGRAY);btnA.setEnabled(false);first=0;found++;}
                                break;
                            case(1):if (!questions.get(currentQuestion).getSolution().equals("B") && first!=1){
                                btnB.setTextColor(Color.DKGRAY);btnA.setEnabled(false);first=1;found++;}
                                break;
                            case(2):if (!questions.get(currentQuestion).getSolution().equals("C") && first!=2){
                                btnC.setTextColor(Color.DKGRAY);btnA.setEnabled(false);first=2;found++;
                                break;}
                            case(3):if (!questions.get(currentQuestion).getSolution().equals("D") && first!=3){
                                btnD.setTextColor(Color.DKGRAY);btnA.setEnabled(false);first=3;found++;}
                                break;
                        }


                }



                btnFiftyfifty.setEnabled(false);
                btnFiftyfifty.setTextColor(Color.RED);
            }
        });
        final Button btnPhone = findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                switch(questions.get(currentQuestion).getSolution()) {
                    case ("A"): btnA.setTextColor(Color.CYAN);break;
                    case ("B"): btnB.setTextColor(Color.CYAN);break;
                    case ("C"): btnC.setTextColor(Color.CYAN);break;
                    case ("D"): btnD.setTextColor(Color.CYAN);break;
                }
                btnPhone.setEnabled(false);
                btnPhone.setTextColor(Color.RED);
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(questions.get(currentQuestion).getSolution().equals("A")){
                    level++;
                    nextQuestion(level);

                }
                else{
                    gameover();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(questions.get(currentQuestion).getSolution().equals("B")){
                    level++;
                    nextQuestion(level);
                }
                else{
                    gameover();
                }

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(questions.get(currentQuestion).getSolution().equals("C")){
                    level++;
                    nextQuestion(level);

                }
                else{
                    gameover();
                }

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if(questions.get(currentQuestion).getSolution().equals("D")){
                    level++;
                    nextQuestion(level);

                }
                else{
                    gameover();
                }

            }
        });



    }



    public void nextQuestion(int level) {
        if(level==16){gameover();}
        else {
            setdefault();
            Button btnA = findViewById(R.id.btnA);
            Button btnB = findViewById(R.id.btnB);
            Button btnC = findViewById(R.id.btnC);
            Button btnD = findViewById(R.id.btnD);
            TextView txtview = findViewById(R.id.txtviewQuestion);
            int size = questions.size();
            currentQuestion = (int) (Math.random() * size + 0);
            while (questions.get(currentQuestion).getLevel() != level) {
                currentQuestion = (int) (Math.random() * size + 0);

            }
            txtview.setText(questions.get(currentQuestion).getQ());
            btnA.setText(questions.get(currentQuestion).getA_answer());
            btnB.setText(questions.get(currentQuestion).getB_answer());
            btnC.setText(questions.get(currentQuestion).getC_answer());
            btnD.setText(questions.get(currentQuestion).getD_answer());
        }

    }

    public void setdefault(){
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        btnA.setTextColor(Color.WHITE);
        btnA.setEnabled(true);
        btnB.setTextColor(Color.WHITE);
        btnB.setEnabled(true);
        btnC.setTextColor(Color.WHITE);
        btnC.setEnabled(true);
        btnD.setTextColor(Color.WHITE);
        btnD.setEnabled(true);

    }

    public void gameover(){
        String score;
        if(level==16){score="1000000";}
        else {score=Integer.toString((level-1)*1000);}

        Bundle bundle = new Bundle();
        bundle.putString("score", score);
        NewScoreItemDialogFragment fragobj =  new NewScoreItemDialogFragment();
        fragobj.setArguments(bundle);
        fragobj.show(getSupportFragmentManager(), NewScoreItemDialogFragment.TAG);
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        TextView txtview= findViewById(R.id.txtviewQuestion);
        txtview.setText("A játék véget ért. Lépj vissza a főmenübe.");

    }

    @Override
    public void onScoreItemCreated( final ScoreItem newItem) {

        new AsyncTask<Void, Void, ScoreItem>() {

            @Override
            protected ScoreItem doInBackground(Void... voids) {
                newItem.id = database.scoreItemDao().insert(newItem);
                return newItem;
            }

        }.execute();
    }


    public void init(){
        questions.add(new Question(1,"Hol található a csarnokvíz?","a pályaudvaron", "a szemben","a tejcsarnokban","barlangfürdőben","B"));
        questions.add(new Question(1,"Melyik járműről elnevezett együttes tagja volt Zorán a 60-as években?","Villamos","HÉV","Autóbusz","Metró","D"));
        questions.add(new Question(1,"Hogy nevezzük másképpen a kárókatonát?","obsitos","treff bubi","bölönbika","kormorán","D"));
        questions.add(new Question(1,"Az alábbiak közül melyik egy sütemény neve?","anyósnyelv","nőiszeszély","pletyka","nőiszirom","B"));
        questions.add(new Question(2,"Hol áll a kilenclyukú híd?","Szegeden","Bugacpusztán","Tokajban","a Hortobágyon","D"));
        questions.add(new Question(2,"Hány korongból áll egy malom az azonos nevű játékban?","kettőből","négyből","háromból","hétből","C"));
        questions.add(new Question(2,"Mit neveznek sasliknak?","sasfészket","vadászfegyvert","nyársonsült húsételt","távcsövet","C"));
        questions.add(new Question(3,"Mit neveztek a középkorban dézsmának?","fa fürdőeszközt","hadizsákmányt","jobbágyi szolgáltatást","őrölt gabonát","C"));
        questions.add(new Question(3,"Milyen állatot szelídít meg a kis herceg a híres regényben?","oroszlánt","rókát","medvét","delfint","B"));
        questions.add(new Question(3,"Melyik város népszerű szórakoztató negyede a Práter?","Párizs","München","Pozsony","Bécs","D"));
        questions.add(new Question(3,"Melyik vár építésénél falazták be Kőmíves Kelemennét?","Drégely","Eger","Déva","Visegrád","C"));
        questions.add(new Question(4,"Mely nép vagy népcsoport nacionalista, fegyveres szervezete az ETA?","ír","baszk","palesztin","tamil","B"));
        questions.add(new Question(5,"Minek a reformjával foglalkozott a Ratio Educationis?","lótenyésztés","kereskedelem","oktatás","hadsereg","C"));
        questions.add(new Question(6,"Melyik a grillázs egyik alapanyaga az alábbiak közül?","tojás","cukor","tejföl","sajt","B"));
        questions.add(new Question(7,"Melyik sportág kiváló szakvezetője volt Komjádi Béla?","úszás","vívás","labdarúgás","vízilabda","D"));
        questions.add(new Question(8,"Ki nem lépett fel színészként?","Petőfi Sándor","Arany János","Vörösmarty Mihály","Katona József","C"));
        questions.add(new Question(9,"Milyen állat a szipoly?","kártevő bogár","mocsári bolha","tavaszi szúnyog","barlangi denevér","A"));
        questions.add(new Question(10,"Mivel foglalkoztak a trapperek?","lovak betörésével","prémvadászattal","aranymosással","dohánytermesztéssel","B"));
        questions.add(new Question(11,"Melyik űrállomáson végzett kutatómunkát Farkas Bertalan?","Szaljut-6","Mir","Skylab","Szaljut-3","A"));
        questions.add(new Question(12,"Az alábbiak közül melyik nem kapta meg a legjobb filmnek járó Oscar-díjat?","Most és mindörökké","Van aki forrón szereti","A muzsika hangja","80 nap alatt a Föld körül","B"));
        questions.add(new Question(13,"Mikor nyílt meg hivatalosan a Szépművészeti Múzeum?","a reformkorban","a kiegyezés évében","a XX. század elején","a II. világháború után","C"));
        questions.add(new Question(14,"Milyen díjat osztanak a trieszti filmfesztiválon?","Arany Polip","Arany Kagyló","Arany Aszteroid","Arany Galamb","C"));
        questions.add(new Question(14,"Az alábbiak közül melyik opera nem tartozik Puccini Triptichonjába?","A köpeny","Nyugat lánya","Angelica nővér","Gianni Schicchi","B"));
        questions.add(new Question(15,"Ki játszotta Lucifer szerepét az Ember tragédiája ősbemutatóján?","Csortos Gyula","Gyenes László","Pethes Imre","Ódry Árpád","B"));
    }




}
