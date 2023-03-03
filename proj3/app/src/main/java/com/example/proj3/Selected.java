package com.example.proj3;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Selected extends BaseObservable {
    @Bindable
    private boolean checked;

    public Selected(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        notifyPropertyChanged(BR.checked);
    }
}
