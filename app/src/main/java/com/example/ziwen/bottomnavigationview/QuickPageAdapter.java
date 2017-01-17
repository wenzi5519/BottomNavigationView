package com.example.ziwen.bottomnavigationview;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * PageAdapter的简化封装
 * @param <T>
 */
public class QuickPageAdapter<T extends View> extends PagerAdapter {
  private List<T> mList;

  public QuickPageAdapter(List<T> mList) {
      this.mList = mList;
  }

  @Override
  public int getCount() {
      return mList.size();
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
      return object == view;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
      container.addView(mList.get(position));
      return mList.get(position);
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView(mList.get(position));
  }
}