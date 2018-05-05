
package com.praveen.test;

import com.praveen.dao.ProductDAO;


public class Test {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getAllProduct());
    }
}
