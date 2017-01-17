# BottomNavigationView

Android Support Library 25 也就是android7.1中增加了 BottomNavigationView 这个控件。感觉挺简单的，用起来也挺方便的。

>注意:
- 底部导航栏高度默认是 56dp。
- 菜单元素只能是 3~5 个。如果个数少于3个或者多于5个，会报错。
- icon 的选中颜色默认是 @color/colorPrimary。可以使用 app:itemIconTint="@android:color/white" 来自定义，这样定以后，所有的 icon 颜色都是这个了。
- 菜单元素文字的默认颜色是 @color/colorPrimary。可以使用 app:itemTextColor="@android:color/white" 自定义。
- 底部导航栏背景颜色默认是当前样式的背景色（白色/黑色），可以使用 app:itemBackground="@android:color/black" 来更改。

```
dependencies
compile 'com.android.support:design:25.0.0'
````
