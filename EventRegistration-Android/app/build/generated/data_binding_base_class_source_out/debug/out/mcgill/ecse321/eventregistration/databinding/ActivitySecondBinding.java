// Generated by view binder compiler. Do not edit!
package mcgill.ecse321.eventregistration.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import mcgill.ecse321.eventregistration.R;

public final class ActivitySecondBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final DrawerLayout myDrawerLayout;

  private ActivitySecondBinding(@NonNull DrawerLayout rootView,
      @NonNull DrawerLayout myDrawerLayout) {
    this.rootView = rootView;
    this.myDrawerLayout = myDrawerLayout;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_second, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySecondBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    DrawerLayout myDrawerLayout = (DrawerLayout) rootView;

    return new ActivitySecondBinding((DrawerLayout) rootView, myDrawerLayout);
  }
}