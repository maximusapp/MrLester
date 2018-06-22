package com.lister.mrlister.mrlester;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lister.mrlister.mrlester.activity.CreateListOfProductActivity;
import com.lister.mrlister.mrlester.activity.NewListActivity;
import com.lister.mrlister.mrlester.adapter.ItemListAdapter;
import com.lister.mrlister.mrlester.adapter.ItemListNewProduct;
import com.lister.mrlister.mrlester.data.Items;
import com.lister.mrlister.mrlester.data.ItemsNewProduct;
import com.lister.mrlister.mrlester.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    ImageView fab;
    ImageView imageView_main;
    TextView textView_main;

    ItemListAdapter itemListAdapter;
    ItemListNewProduct itemListNewProduct;

    RecyclerView recyclerView_main;


    DatabaseHelper databaseHelper;

    Menu menu;

    int id;

    AlertDialog.Builder alert;
    LinearLayout view;

    TextView textView_edit;
    TextView textView_delete;
    Button button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        fab = findViewById(R.id.fab);

        imageView_main = findViewById(R.id.image_main_screen);
        textView_main = findViewById(R.id.text_main_screen);

        recyclerView_main = findViewById(R.id.recycler_main);

        databaseHelper = new DatabaseHelper(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView_main.setLayoutManager(mLayoutManager);


        itemListAdapter = new ItemListAdapter(this, databaseHelper.listData()){
            @Override
            public void OnClickLister(Items items) {
                Intent intentNewProductList = new Intent(MainActivity.this, CreateListOfProductActivity.class);
                intentNewProductList.putExtra("title", items.getTitle());
                intentNewProductList.putExtra("color", items.getColor());
                intentNewProductList.putExtra("id", items.getId());
                startActivity(intentNewProductList);
                Log.d("TITLE_IS", items.getTitle());
                System.out.println("COLOR_IS " + items.getColor());
                System.out.println("ID_IS " + items.getId());
                id = items.getId();
            }

            @Override
            public void OnClicMenu(Items items) {

                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.menu_for_item_main_list, null);
                textView_edit = view.findViewById(R.id.edit);
                textView_delete = view.findViewById(R.id.delete);
                button_cancel = view.findViewById(R.id.cancel);

                mDialogBuilder.setView(view);
                final AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();

                button_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

            }
        };


        itemListNewProduct = new ItemListNewProduct(this, databaseHelper.productsData(id)){
            @Override
            public void ClickChecked(ItemsNewProduct itemsNewProduct) {

            }
        };

        recyclerView_main.setAdapter(itemListAdapter);
        itemListAdapter.notifyDataSetChanged();



        if (itemListAdapter.getItemCount() == 0) {
            imageView_main.setVisibility(View.VISIBLE);
            textView_main.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
            recyclerView_main.setVisibility(View.INVISIBLE);
        } else {
            imageView_main.setVisibility(View.INVISIBLE);
            textView_main.setVisibility(View.INVISIBLE);
            fab.setVisibility(View.INVISIBLE);
            recyclerView_main.setVisibility(View.VISIBLE);
        }


        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation);

        //fab.startAnimation(animation);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNewList = new Intent(MainActivity.this, NewListActivity.class);
                startActivity(intentNewList);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
        MenuItem add = menu.findItem(R.id.action_add);

        if (itemListAdapter.getItemCount() != 0) {
            add.setVisible(true);
            fab.setVisibility(View.INVISIBLE);
        } else {
                add.setVisible(false);
                fab.setVisibility(View.VISIBLE);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add) {
            Intent intentNewList = new Intent(MainActivity.this, NewListActivity.class);
            startActivity(intentNewList);
            //Toast.makeText(this, "Replace with your own action", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}