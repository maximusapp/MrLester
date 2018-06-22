package com.lister.mrlister.mrlester.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lister.mrlister.mrlester.R;
import com.lister.mrlister.mrlester.adapter.ItemListNewProduct;
import com.lister.mrlister.mrlester.data.ItemsNewProduct;
import com.lister.mrlister.mrlester.database.DatabaseHelper;

public class CreateListOfProductActivity extends AppCompatActivity {

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    String name;
    String lister_title;

    EditText editText;
    RecyclerView recycler_products;
    ItemListNewProduct itemListNewProduct;
    DatabaseHelper databaseHelper;

    int toolbar_color;
    int id;
    int checked;
    int count;
    int countAll;

    TextView textView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list_of_product);
        Toolbar toolbar = findViewById(R.id.toolbar_new_list);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get title from stringExtra from Main Activity.
        Intent intentData = getIntent();
        lister_title = intentData.getStringExtra("title");
        toolbar_color = intentData.getIntExtra("color", 1);
        id = intentData.getIntExtra("id", 1);
        getSupportActionBar().setTitle(lister_title);

        databaseHelper = new DatabaseHelper(this);

        textView = findViewById(R.id.text_in_list_of_product);

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

        editText = findViewById(R.id.write_product);
        editText.setOnEditorActionListener(new DoneOnEditorActionListener());

        recycler_products = findViewById(R.id.recycler_products);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recycler_products.setLayoutManager(mLayoutManager);
        itemListNewProduct = new ItemListNewProduct(this, databaseHelper.productsData(id)){
            @Override
            public void ClickChecked(ItemsNewProduct itemsNewProduct) {
                Log.d("CHECKED_OR_NO", String.valueOf(itemsNewProduct.getChecked()));
                checked = itemsNewProduct.getChecked();

                int id_for_change = itemsNewProduct.getId();
                Log.d("ID_FOR_CHANGE", String.valueOf(id_for_change));
                UpdateData(id_for_change, checked);

            }
        };

        countAll = databaseHelper.countAll(checked);
        count = databaseHelper.countChecked(checked);
        getSupportActionBar().setSubtitle(count + "/" + countAll);


        recycler_products.setAdapter(itemListNewProduct);
        itemListNewProduct.notifyDataSetChanged();

        if (itemListNewProduct != null) {
            recycler_products.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        } else {
            recycler_products.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }

        if (toolbar_color == 1) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_one);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Drawable background = getResources().getDrawable(R.drawable.gradient_one);
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                   // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                    window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 2) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_two);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_two);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 3) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_three);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_three);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 4) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_four);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_four);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 5) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_five);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_five);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 6) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_six);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_six);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 7) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_seven);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_seven);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 8) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_eight);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_eight);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }

        if (toolbar_color == 9) {
            toolbar.setBackgroundResource(R.drawable.grad_tool_nine);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Drawable background = getResources().getDrawable(R.drawable.gradient_nine);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
                // window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
                window.setBackgroundDrawable(background);
            }
        }
    }


    // Handle Done Button on KeyBoard of Telephone.
    class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                name = editText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter product name", Toast.LENGTH_LONG).show();
                } else {
                    AddData(name, id, checked);
                    editText.setText("");
                    Toast.makeText(getApplicationContext(), "Product " + name + " inserted", Toast.LENGTH_LONG).show();
                }
                return true;
            }
            return false;
        }
    }

    // Update data in SQLite.
    private void UpdateData(int id, int checked) {
        boolean update = databaseHelper.updateProductList(id, checked);
        if (update) {
            this.recreate();
        } else {
            Toast.makeText(this, "Data not updated", Toast.LENGTH_SHORT).show();
        }
    }

    // Add data to SQLite.
    private void AddData(String named, int id, int checked) {
        boolean insertData = databaseHelper.addProduct(named, id, checked);
        if (insertData) {
            this.recreate();
        } else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }

}