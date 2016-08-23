# Test_RecyclerView
1. 照着慕课网上的视频敲了一遍


##总结
 
 1. LayoutManager去实现ListView、GridView、横向ListView/GridView、瀑布流
 2. ItemDecoration 设置item间的分隔 。 实现的原理和如何定制     private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
 3. ItemAnimator的使用  github上有项目


###遗憾的是 recyclerView没有提供点击事件的回调  只能手动在Adapter提供的Item添加Click/longcClick的回调
