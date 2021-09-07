package com.xSavior_of_God.fullscreenbrowser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class settingsDialog extends DialogFragment {
  public EditText url, refresh;
  private TextView mActionOk, mActionCancel;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.settings_dialog, container, false);
    mActionCancel = view.findViewById(R.id.action_cancel);
    mActionOk = view.findViewById(R.id.action_ok);
    url = view.findViewById(R.id.inputUrl);
    refresh = view.findViewById(R.id.inputRefresh);
    url.setText(FullscreenActivity.instance.webView.getUrl()+"");
    refresh.setText(FullscreenActivity.instance.refresh+"");

    mActionCancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getDialog().dismiss();
      }
    });


    mActionOk.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String link = url.getText().toString();
        int ref = 10000;
        try {
          ref = Math.max(Integer.parseInt(refresh.getText().toString()), ref);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        FullscreenActivity.instance.refreshUrl(url.getText().toString());
        FullscreenActivity.instance.updateRefresh(ref);
      }
    });

    return view;
  }

}