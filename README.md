###activity滑动返回原理
我们滑动的其实是activity里面的可见view元素，而我们将activity设置为透明的，这样当view滑过的时候，由于activity的底部是透明的，我们就可以在滑动过程中看到下面的activity，这样看起来就是在滑动activity。
###实现
  使用framlayout自定义的帧布局  去进行页面的重合添加
  
  
         /**
             * activity界面view的重叠替换显示
             * @param activity
             */
            public void replaceLayer(Activity activity) {
                touchSlop = (int) (touchSlopDP * activity.getResources().getDisplayMetrics().density);
                sideWidth = (int) (sideWidthInDP * activity.getResources().getDisplayMetrics().density);
                mActivity = activity;
                screenWidth = getScreenWidth(activity);
                setClickable(true);
                backgroundLayer = new View(activity);
                backgroundLayer.setBackgroundColor(layerColor);
                final ViewGroup root = (ViewGroup) activity.getWindow().getDecorView();
                content = root.getChildAt(0);
                //在Android5.0上，content的高度不再是屏幕高度，而是变成了Activity高度，比屏幕高度低一些，
                //如果this.addView(content),就会使用以前的params，这样content会像root一样比content高出一部分，导致底部空出一部分
                //在装有Android 5.0的Nexus5上，root,SwipeLayout和content的高度分别是1920、1776、1632，144的等差数列……
                //在装有Android4.4.3的HTC One M7上，root,SwipeLayout和content的高度分别相同，都是1920
                //所以我们要做的就是给content一个新的LayoutParams，Match_Parent那种，也就是下面的-1
                ViewGroup.LayoutParams params = content.getLayoutParams();
                ViewGroup.LayoutParams params2 = new ViewGroup.LayoutParams(-1, -1);
                ViewGroup.LayoutParams params3 = new ViewGroup.LayoutParams(-1, -1);
                root.removeView(content);
                this.addView(backgroundLayer, params3);
                this.addView(content, params2);
                root.addView(this, params);
            }
            
            
###注：要设置基类主题样式
  
  
             <!--<item name="android:windowIsTranslucent">true</item>
        样式中添加这个，当activity 启动销毁 左右动画时，可呈现特殊效果。即退出的activity无动画效果,
        而且如果下一个activity设为singleInstance，当前activity这个属性为透明即可防止启动时闪屏
        -->
        <style name="ActivityTheme" parent="AppBaseTheme">
            <!-- All customizations that are NOT specific to a particular API-level can go here. -->
            <item name="android:listDivider">@drawable/recycler_divider</item>
            <item name="android:windowBackground">@*android:color/transparent</item><!--背景透明-->
            <item name="android:windowIsTranslucent">true</item>
        </style>
        
 主要是通过手势的获取，滑动的距离，滑动的速度来设置界面的位移动画和透明度的显示变化，以及滑动的回弹和界面activity的消费
