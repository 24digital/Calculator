package com.android.marion.calculator;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements Parcelable {
    private CalculatorEngine calculatorEngine;
    private Button buttonC;
    private Button buttonCE;
    private Button buttonMinusPlus;
    private Button buttonSlash;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonTimes;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonZero;
    private Button buttonMinus;
    private Button buttonPeriod;
    private Button buttonEquals;
    private Button buttonPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorEngine = new CalculatorEngine();
        registerWidgets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CalculatorEngine engine = (CalculatorEngine) savedInstanceState.getSerializable("obj");
        if (engine != null)
            calculatorEngine = engine;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("obj", calculatorEngine);
    }

    public void registerWidgets() {
        //ButtonC
        buttonC = (Button) findViewById(R.id.ButtonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine.clear();
                refreshDisplay();
            }
        });

        //ButtonCE
        buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine.clearEntry();
                refreshDisplay();
            }
        });

        //ButtonMinusPlus
        buttonMinusPlus = (Button) findViewById(R.id.buttonPlusMinus);
        buttonMinusPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorEngine.toggleSign();
                refreshDisplay();

            }
        });

        //ButtonSlash
        buttonSlash = (Button) findViewById(R.id.buttonSlash);
        buttonSlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshDisplay("/");

                calculatorEngine.perform(Operation.DIVIDE);
            }
        });

        //ButtonSeven
        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('7');
            }
        });

        //ButtonEight
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('8');
            }
        });

        //ButtonNine
        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('9');
            }
        });


        //ButtonTimes
        buttonTimes = (Button) findViewById(R.id.buttonTimes);
        buttonTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshDisplay("*");
                calculatorEngine.perform(Operation.MULTIPLY);
            }
        });

        //ButtonFour
        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('4');
            }
        });

        //Buttonfive
        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('5');
            }
        });

        //ButtonSix
        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('6');
            }
        });

        //ButtonOne
        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('1');
            }
        });

        //ButtonTwo
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('2');
            }
        });

        //ButtonThree
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('3');
            }
        });

        //ButtonEight
        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('8');
            }
        });

        //ButtonZero
        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('0');
            }
        });

        //ButtonMinus
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshDisplay("-");
                calculatorEngine.perform(Operation.SUBTRACT);
            }
        });


        //ButtonPeriod
        buttonPeriod = (Button) findViewById(R.id.buttonPeriod);
        buttonPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute('.');
            }
        });

        //ButtonEquals
        buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView view = (TextView) findViewById(R.id.result);
                view.setText(calculatorEngine.toString());

            }
        });

        //ButtonPlus
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshDisplay("+");
                        calculatorEngine.perform(Operation.ADD);
                    }
                });
            }
        });
    }

    private void compute(Character number) {

        calculatorEngine.insert(number);
        refreshDisplay();

    }


    private void refreshDisplay() {
        String temp = calculatorEngine.getDisplay();
        TextView view = (TextView) findViewById(R.id.result);
        view.setText(temp);
    }

    private void refreshDisplay(String i) {

        TextView view = (TextView) findViewById(R.id.result);
        view.setText(i);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
