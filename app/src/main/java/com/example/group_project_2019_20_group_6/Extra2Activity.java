package com.example.group_project_2019_20_group_6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Extra2Activity extends AppCompatActivity {

    ImageView imageView;
    int childPosition;
    int groupPosition;
    TextView Title;
    TextView showValue;
    int counter=0;// counter starts at zero



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra2);


        ActionBar actionBar=getSupportActionBar();

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        imageView=findViewById(R.id.imageView2);
        Title=findViewById(R.id.titleView);
        showValue=findViewById(R.id.counterValue);
        showValue.setText(Integer.toString(counter));



        if (groupPosition==0){
            if(childPosition==0){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();

                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");

                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==1){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==2){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }

        }
        else if (groupPosition==1){
            if(childPosition==0){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==1){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==2){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
        }
        else if (groupPosition==2){
            if(childPosition==0){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==1){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
            if(childPosition==2){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
        }
        else if (groupPosition==3)
            if(childPosition==0){
                Intent intent=getIntent();

                Bundle bundle= this.getIntent().getExtras();
                int pic=bundle.getInt("Image");
                String aTitle=intent.getStringExtra("title");


                imageView.setImageResource(pic);
                Title.setText(aTitle);

            }
        if(childPosition==1){
            Intent intent=getIntent();

            Bundle bundle= this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("title");


            imageView.setImageResource(pic);
            Title.setText(aTitle);

        }




    }

    public void CountIN (View view){
        if (counter>=0){
            counter++;
            showValue.setText(Integer.toString(counter));
        }
    }

    public void CountDE (View v){
        if (counter>0){
            counter--;
            showValue.setText(Integer.toString(counter));
        }

    }
}
