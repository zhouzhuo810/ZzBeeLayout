# ZzBeeLayout
A nice Image ViewGroup like honeycomb.

<h2>What does it look like ?</h2>


![demo.jpg](https://github.com/zhouzhuo810/ZzBeeLayout/blob/master/demo.jpg)


<h2>How to use it ?</h2>

**Gradle**

```
compile 'me.zhouzhuo.zzbeelayout:zz-bee-layout:1.0.1'
```

**Maven**

```xml
<dependency>
  <groupId>me.zhouzhuo.zzbeelayout</groupId>
  <artifactId>zz-bee-layout</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```


① layout

```xml
    <me.zhouzhuo.zzbeelayout.ZzBeeLayout
        android:id="@+id/bee"
        android:layout_centerInParent="true"
        android:layout_width="300dp"
        android:layout_height="300dp"
        app:zz_def_res="@mipmap/ic_launcher"
        app:zz_child_size="100dp">

    </me.zhouzhuo.zzbeelayout.ZzBeeLayout>
```

属性说明：

属性 | 说明 | 类型
----|------|----
zz_def_res| 默认加载中图片或颜色|图片或颜色资源id
zz_child_size|每张图片默认宽度|尺寸(dp)



② java

```java

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
        
        //resize if necessary
        zzBeeLayout.getLayoutParams().width = 900;
        zzBeeLayout.getLayoutParams().height = 900;
        zzBeeLayout.setChildSize(300);

```

<h2>Permissions</h2>

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```
