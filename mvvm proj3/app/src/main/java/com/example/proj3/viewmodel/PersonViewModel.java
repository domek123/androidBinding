package com.example.proj3.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proj3.model.Person;

public class PersonViewModel extends ViewModel {
    private MutableLiveData<Person> personMutableLiveData;
    private Person person;
    public PersonViewModel(){
        this.personMutableLiveData = new MutableLiveData<>();
        this.person = new Person("MALE","TOMASZ");
    }
    public void setupPerson(){
        this.personMutableLiveData.setValue(this.person);
    }
    public MutableLiveData<Person> getObservedPerson(){
        return personMutableLiveData;
    }
    public void changePerson(String genre,String name){
        this.person.setGenre(genre);
        this.person.setName(name);
        this.personMutableLiveData.setValue(this.person);
    }
    public String getPersonName(){
        return person.getName();}
    public String getPersonGenre(){
        return person.getGenre();}
    public void setPersonName(String name){
        this.person.setName(name);

    }
    public void setPersonGenre(String genre){
        this.person.setGenre(genre);

    }
}
