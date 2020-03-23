package com.example.books;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencebooks;
    List<Book>book = new ArrayList<>();
   public FirebaseDatabaseHelper(){
       mDatabase = FirebaseDatabase.getInstance();
       mReferencebooks = mDatabase.getReference("books");

   }
   public interface DataStatus{
       void DataIsLoaded(Book<List>books);
   }
   public void readBooks(){
       mReferencebooks.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            books.clear();
            List<String> keys = new ArrayList<>();
            for(DataSnapshot keynode : dataSnapshot.getChildren()){
                keys.add(keynode.getKey());
                Book book = keynode.getValue(Book.class);
                books.add(book);
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
   }
}
