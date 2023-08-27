package com.example.shoppingcart_quiz1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        com.example.shoppingcart_quiz1.Order cart = (com.example.shoppingcart_quiz1.Order) session.getAttribute("cart");
        if (cart != null) {
            double totalAmount = cart.getTotalAmount();
            // Add your payment processing logic here
            // For simplicity, let's just clear the cart after payment
            cart.clear();
        }

        response.sendRedirect("index.jsp");
    }
}
