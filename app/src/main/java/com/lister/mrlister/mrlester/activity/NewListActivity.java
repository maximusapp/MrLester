package com.lister.mrlister.mrlester.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lister.mrlister.mrlester.MainActivity;
import com.lister.mrlister.mrlester.R;
import com.lister.mrlister.mrlester.database.DatabaseHelper;

public class NewListActivity extends AppCompatActivity {

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    // Icons gradient.
    ImageView image_first_color;
    ImageView image_sec_color;
    ImageView image_threed_color;
    ImageView image_four_color;
    ImageView image_five_color;
    ImageView image_six_color;
    ImageView image_seven_color;
    ImageView image_eight_color;
    ImageView image_nine_color;
    ImageView imageView_ten_color;

    // Icons icon.
    ImageView imageView_one;
    ImageView imageView_two;
    ImageView imageView_three;
    ImageView imageView_four;
    ImageView imageView_five;
    ImageView imageView_six;
    ImageView imageView_seven;
    ImageView imageView_eight;
    ImageView imageView_nine;
    ImageView imageView_ten;
    ImageView imageView_eleven;
    ImageView imageView_twelve;
    ImageView imageView_thirteen;
    ImageView imageView_fourteen;
    ImageView imageView_fifteen;
    ImageView imageView_sixteen;
    ImageView imageView_seventeen;
    ImageView imageView_eighteen;
    ImageView imageView_nineteen;
    ImageView imageView_twenty;

    String title;
    EditText editText_list_title;

    Button button_create_list;

    DatabaseHelper databaseHelper;

    int setColor = 0;
    int setIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);
        Toolbar toolbar = findViewById(R.id.toolbar_new_list);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set statusBar color
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorWhite));
        }

        image_first_color = findViewById(R.id.fist_color);
        image_sec_color = findViewById(R.id.second_color);
        image_threed_color = findViewById(R.id.third_color);
        image_four_color = findViewById(R.id.four_color);
        image_five_color = findViewById(R.id.five_color);
        image_six_color = findViewById(R.id.six_color);
        image_seven_color = findViewById(R.id.seven_color);
        image_eight_color = findViewById(R.id.eight_color);
        image_nine_color = findViewById(R.id.nine_color);
        imageView_ten_color = findViewById(R.id.ten_color);


        image_first_color.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setColor = 1;
            }
        });

        image_sec_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 2;
            }
        });

        image_threed_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 3;
            }
        });

        image_four_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 4;
            }
        });

        image_five_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 5;
            }
        });

        image_six_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 6;
            }
        });

        image_seven_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 7;
            }
        });

        image_eight_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 8;
            }
        });

        image_nine_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor = 9;
            }
        });

        // Choose custom gradient color for Item.
        imageView_ten_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Find icons of category.
        imageView_one = findViewById(R.id.image_icon_one);
        imageView_two = findViewById(R.id.image_icon_two);
        imageView_three = findViewById(R.id.image_icon_three);
        imageView_four = findViewById(R.id.image_icon_four);
        imageView_five = findViewById(R.id.image_icon_five);
        imageView_six = findViewById(R.id.image_icon_six);
        imageView_seven = findViewById(R.id.image_icon_seven);
        imageView_eight = findViewById(R.id.image_icon_eight);
        imageView_nine = findViewById(R.id.image_icon_nine);
        imageView_ten = findViewById(R.id.image_icon_ten);
        imageView_eleven = findViewById(R.id.image_icon_eleven);
        imageView_twelve = findViewById(R.id.image_icon_twelve);
        imageView_thirteen = findViewById(R.id.image_icon_threteen);
        imageView_fourteen = findViewById(R.id.image_icon_fourteen);
        imageView_fifteen = findViewById(R.id.image_icon_fifteen);
        imageView_sixteen = findViewById(R.id.image_icon_sixteen);
        imageView_seventeen = findViewById(R.id.image_icon_seventeen);
        imageView_eighteen = findViewById(R.id.image_icon_eighteen);
        imageView_nineteen = findViewById(R.id.image_icon_nineteen);
        imageView_twenty = findViewById(R.id.image_icon_twenty);

        imageView_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 1;
            }
        });

        imageView_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 2;
            }
        });

        imageView_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 3;
            }
        });

        imageView_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 4;
            }
        });

        imageView_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 5;
            }
        });

        imageView_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 6;
            }
        });

        imageView_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 7;
            }
        });

        imageView_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 8;
            }
        });

        imageView_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 9;
            }
        });

        imageView_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 10;
            }
        });

        imageView_eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 11;
            }
        });

        imageView_twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 12;
            }
        });

        imageView_thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 13;
            }
        });

        imageView_fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 14;
            }
        });

        imageView_fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 15;
            }
        });

        imageView_sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 16;
            }
        });

        imageView_seventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 17;
            }
        });

        imageView_eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 18;
            }
        });

        imageView_nineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 19;
            }
        });

        imageView_twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIcon = 20;
            }
        });

        databaseHelper = new DatabaseHelper(this);

        editText_list_title = findViewById(R.id.enter_list_name);

        button_create_list = findViewById(R.id.create_list_button);
        button_create_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText_list_title.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Enter name of List", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else {
                    title = editText_list_title.getText().toString();
                    AddData(title, setColor, setIcon);
                }
            }
        });


    }

    private void AddData(String title, int color, int icon) {

        boolean insertData = databaseHelper.addData(title, color, icon);

        if (insertData) {
            Toast.makeText(this, "Data inserted success", Toast.LENGTH_SHORT).show();
            Intent intentMain = new Intent(NewListActivity.this, MainActivity.class);
            startActivity(intentMain);
            finish();
        } else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }

}