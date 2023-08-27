package com.example.shoppingcart_quiz1;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order cart = (Order) session.getAttribute("cart");
        if (cart == null) {
            cart = new Order();
            session.setAttribute("cart", cart);
        }

        String clearCart = request.getParameter("clearCart");
        if (clearCart != null && clearCart.equalsIgnoreCase("true")) {
            cart.clear();
        } else {
            String productIndex = request.getParameter("product");
            String quantityStr = request.getParameter("quantity");
            int quantity = 1;
            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException ignored) {
            }

            Product selectedProduct = null;
            List<com.example.shoppingcart_quiz1.Product> products = List.of(
                    new com.example.shoppingcart_quiz1.Product("Product A", 10.0),
                    new com.example.shoppingcart_quiz1.Product("Product B", 15.0),
                    new com.example.shoppingcart_quiz1.Product("Product C", 20.0)
            );

            try {
                int index = Integer.parseInt(productIndex);
                if (index >= 0 && index < products.size()) {
                    selectedProduct = products.get(index);
                }
            } catch (NumberFormatException ignored) {
            }

            if (selectedProduct != null) {
                cart.addItem(selectedProduct, quantity);
            }
        }

        response.sendRedirect("index.jsp");
    }
}
