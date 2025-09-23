# Product data: (Product ID, Price, Stock Quantity)
products = [
    ("p001", 150.00, 5),
    ("p002", 200.00, 0),
    ("p003", 50.50, 10),
    ("p004", "99.99", 3),  # Note: Price is a string
    ("p005", 300.00, 0),
    ("p006", 75.00, -1),   # Note: Negative stock
]
def process_stock(product_list):  # Fixed missing colon
    total_value = 0
    out_of_stock_items = []
    for product in product_list:
        # Convert price to float if it is a string
        price = float(product[1]) if isinstance(product[1], str) else product[1]
        stock = max(product[2], 0)  # Handle negative stock by treating it as 0
        # Calculate the value of each product in stock
        stock_value = price * stock
        total_value += stock_value  # Fixed: use += instead of overwriting
        # Check for out of stock items
        if stock == 0:
            out_of_stock_items.append(product[0])  # Fixed .add() -> .append() for list
    return total_value, out_of_stock_items

# Call the function and unpack results
total_value, out_of_stock = process_stock(products)

print(f"Total value of all stock: {total_value}")  # Corrected variable name
print(f"Out of stock products: {out_of_stock}")   # Corrected variable name
