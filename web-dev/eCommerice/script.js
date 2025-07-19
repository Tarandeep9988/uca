function f() {
    if (document.getElementById("tag1")) {
        document.getElementById("tag1").innerHTML = "Content updated";
    }
};
// Self invoking functions
// This pattern is highly used in frameworks

setTimeout(f, 2000);


var productList = [];

function loadProducts() {
    document.getElementById('tag2').innerHTML = `
    <table border='1' cellspacing='0'>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                </tr>
                    <td>Product 1</td>
                    <td>$10.00</td>
                    <td>Gre8 Product</td>
                <tr>
                </tr>
                    <td>Product 2</td>
                    <td>$12.00</td>
                    <td>Gre8 Product</td>
                <tr>
                </tr>
                    <td>Product 3</td>
                    <td>$15.00</td>
                    <td>Gre8 Product</td>
                <tr>
            </tbody>
        </table>
    `
}

const loadData = () => {
    productList = [
        {
            name: "Laptop",
            price: 55000,
            description: "A fast laptop with 16GB RAM and SSD"
        },
        {
            name: "Headphones",
            price: 2500,
            description: "Noise-cancelling over-ear headphones"
        },
        {
            name: "Smartphone",
            price: 30000,
            description: "5G-enabled smartphone with great camera"
        }
    ];

}

setTimeout(loadData, 2000);

setTimeout(loadProducts, 2000);




console.log(x);
var x = 10;

