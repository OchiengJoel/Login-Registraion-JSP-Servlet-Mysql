/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.app1.exmrecord;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String name = request.getParameter("name");

        String pass = request.getParameter("pass");

        String email = request.getParameter("email");

        MyDb db = new MyDb();

        Connection con = db.getCon();

        try {

        Statement stmt =  con.createStatement();

        stmt.executeUpdate("insert into user (uname,upass,email)values('"+ name +"','"+ pass +"','"+ email +"')");

        out.println("data inserted sucessfully");

        } catch (SQLException e) {

        // TODO Auto-generated catch block

        e.printStackTrace();

        }
       
    }

}
