package com.example.dictionary;

import java.util.HashMap;
import java.sql.*;

public class HashmapDictionary {
    HashMap<String,String>hm=new HashMap<>();
    static String meaning1;
    HashmapDictionary() {


        addword("apple", "apple is fruit");
        addword("car", "is vehicle with four wheels");
    }
public boolean addword(String s1,String s2)
{
    hm.put(s1,s2);
    return true;
}
public String find(String s)
{
    final String DB_URL = "jdbc:mysql://localhost:3306/my_dict";
    final String USER = "root";
    final String PASS = "110222610";

    System.out.println("Connecting to database");
    String newId = "select word,meaning from dictionary where word= '"+ s+"'";
    try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(newId);
    )

    {while(rs.next()) {
        meaning1 = rs.getString("meaning");
    }
        rs.close();
        if(!meaning1.isBlank()) {

            return meaning1;
        }
        else {return "no wor";}


    } catch(
            SQLException e)

    {
        e.printStackTrace();
    }

   if( hm.containsKey(s))
   {
       return hm.get(s);
   }
else
return "no word";}
}
