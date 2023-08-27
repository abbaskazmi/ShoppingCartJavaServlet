<!-- index.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Welcome to the Shopping Cart</h1>
<form action="CartServlet" method="post">
    <label for="product">Select a product:</label>
    <select name="product" id="product">
        <option value="0">Product A - $10.00</option>
        <option value="1">Product B - $15.00</option>
        <option value="2">Product C - $20.00</option>
    </select>
    <label for="quantity">Quantity:</label>
    <input type="number" name="quantity" id="quantity" min="1" value="1">
    <input type="submit" value="Add to Cart">
</form>

<h2>Your Shopping Cart:</h2>
<table border="1">
    <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <c:forEach var="item" items="${cart.getItems()}">
        <tr>
            <td>${item.getProduct().getName()}</td>
            <td>${item.getQuantity()}</td>
            <td>${item.getProduct().getPrice()}</td>
        </tr>
    </c:forEach>
</table>

<h3>Total Amount: $${cart.getTotalAmount()}</h3>

<form action="CartServlet" method="post">
    <input type="hidden" name="clearCart" value="true">
    <input type="submit" value="Clear Cart">
</form>

<form action="PaymentServlet" method="post">
    <input type="submit" value="Process Payment">
</form>
</body>
</html>
