package me.zhouzhuo.zzbeelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.zhouzhuo.zzbeelayout.ZzBeeLayout;
import me.zhouzhuo.zzbeelayout.widget.com.meg7.widget.SvgImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZzBeeLayout zzBeeLayout = (ZzBeeLayout) findViewById(R.id.bee);

        //from http url
        zzBeeLayout.setImageUrls(new String[]{
                "http://img0.imgtn.bdimg.com/it/u=3273293410,2667810732&fm=11&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=3271149477,3744926107&fm=11&gp=0.jpg",
                "http://img4.imgtn.bdimg.com/it/u=4186654312,3515491732&fm=23&gp=0.jpg",
                "http://img2.imgtn.bdimg.com/it/u=1192715945,443541801&fm=21&gp=0.jpg",
                "http://img3.imgtn.bdimg.com/it/u=2016448457,3556493612&fm=23&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=2155062783,607707723&fm=23&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2404996392,2561119365&fm=23&gp=0.jpg"
        });

/*
        //from drawable res
        zzBeeLayout.setImageRes(new int[] {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six,
                R.drawable.seven
        });*/

        //from file Uri
        //...

        //from file Path
        //...


        //set click listener
        zzBeeLayout.setOnImageClickListener(new ZzBeeLayout.OnImageClickListener() {
            @Override
            public void onImageClick(SvgImageView iv, int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
