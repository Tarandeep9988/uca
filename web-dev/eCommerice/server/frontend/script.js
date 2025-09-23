
var productList = [];

const foo = (product) => {
    console.log(product);

}


function renderProducts() {
    
    function renderProductsListWithData() {
        if (productList.length === 0) {
            document.getElementById('data').innerHTML = 'Loading data from server...';
            return;
        }
        document.getElementById('data').innerHTML = `
    <table>
            <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                ${
                    (productList.map((product, i) => {
            return `
                        <tr>
                            <td>${i + 1}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.description}</td>
                        </tr>
                    `
        })).join("")
    }
            </tbody>
        </table>
    `
    }
    loadProducts(renderProductsListWithData);
    
    
    renderProductsListWithData();
    // fetch the data from html and render the it on ui
}

const loadProducts = (f) => {
    setTimeout(() => {
        productList = productListFromServer
       
        f();  
    }, 1000);
}

renderProducts();

// setTimeout(renderProducts, 2000);

