package com.example.proj4.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proj4.model.User;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> mutableUserList;
    private ArrayList<User> userList;
    public UserViewModel() {

        this.mutableUserList = new MutableLiveData<>();

        userList = new ArrayList<>();

        // baza danych userów na start

        userList.add(new User(1, "Jan"));
        userList.add(new User(2, "Anna"));
        userList.add(new User(3, "Piotr"));

        // wpisanie do mutable dla obserwacji

        this.mutableUserList.setValue(this.userList);
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void deleteUser(int id){

    }
}
